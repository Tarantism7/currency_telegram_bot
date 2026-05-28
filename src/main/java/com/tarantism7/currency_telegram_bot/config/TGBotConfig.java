package com.tarantism7.currency_telegram_bot.config;

import com.tarantism7.currency_telegram_bot.bot.Bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
@Slf4j
public class TGBotConfig {
    @Bean
    TelegramBotsApi telegramBotsApi(Bot bot) {
        TelegramBotsApi botsApi = null;
        try{
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            log.error("Error while sending msg to telegram");
        }
        return botsApi;
    }
}
