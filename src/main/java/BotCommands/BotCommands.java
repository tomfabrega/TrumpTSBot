package BotCommands;

import Bot.Donaldtrump;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

import java.util.List;

public interface BotCommands {
    Boolean isAdminCommand = null;

    String command = null;

    public String getCommand();

    public Boolean getIsAdminCommand();

    public void execute(Donaldtrump dt, User u, List<String> args, TextMessageEvent textMessageEvent, ClientInfo invokerClient);

    ;
}
