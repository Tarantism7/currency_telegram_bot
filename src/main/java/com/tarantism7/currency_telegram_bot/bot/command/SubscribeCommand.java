package com.tarantism7.currency_telegram_bot.bot.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Service
@Slf4j
public class SubscribeCommand implements IBotCommand {
    @Override
    public String getCommandIdentifier() {
        return "subscribe";
    }

    @Override
    public String getDescription() {
        return "subscribe to bitcoin price";
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {

    }
}
