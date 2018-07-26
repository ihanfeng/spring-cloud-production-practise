package com.github.richterplus.common.stream.processor;

import com.github.richterplus.common.entity.Log;
import com.github.richterplus.common.repository.LogRepository;
import com.github.richterplus.common.stream.binding.LogAppenderBinding;
import com.github.richterplus.common.stream.message.LogAppenderMessage;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(LogAppenderBinding.class)
class LogAppenderProcessor {

    @Autowired
    private LogRepository logRepository;

    @StreamListener(LogAppenderBinding.INPUT)
    public void consume(LogAppenderMessage message) {
        try {
            logRepository.create(new Log() {
                {
                    setLogType(message.getLogType());
                    setUserId(message.getUserId());
                    setMessage(message.getMessage());
                    setObjectIds(message.getObjectIds().stream().map(Object::toString).reduce((a, b) -> a + "," + b).orElse(""));
                    setLogUuid(message.getLogUuid());
                    setLogDate(message.getRequestDateTime());
                }
            });
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
