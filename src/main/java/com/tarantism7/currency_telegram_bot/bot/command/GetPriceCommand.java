package com.tarantism7.currency_telegram_bot.bot.command;

import com.tarantism7.currency_telegram_bot.service.CryptoCurrencyService;
import com.tarantism7.currency_telegram_bot.util.TextUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Service
@AllArgsConstructor
@Slf4j
public class GetPriceCommand implements IBotCommand {
    private final CryptoCurrencyService cryptoCurrencyService;

    @Override
    public String getCommandIdentifier() {
        return "get_price";
    }

    @Override
    public String getDescription() {
        return "Returns the price of a currency.";
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {
        SendMessage answer =  new SendMessage();
        answer.setChatId(message.getChatId());
        try{
            answer.setText("Current price is " + TextUtil.toString(cryptoCurrencyService.getBitcoinPrice()) + "USD");
            absSender.execute(answer);
        } catch (Exception e){
            log.error("Error while getting currency price", e);
        }
    }
}
