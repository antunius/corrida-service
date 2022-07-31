package br.com.marcus.corrida.config

import feign.micrometer.MicrometerCapability
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FeignConfig {

    @Bean
    fun micrometerCapability(meterRegistry: MeterRegistry?): MicrometerCapability? {
        return MicrometerCapability(meterRegistry)
    }
}