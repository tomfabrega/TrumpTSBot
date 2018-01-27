package BotCommands;

import Bot.Donaldtrump;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;
import com.sun.deploy.util.StringUtils;

import java.util.List;

public class BotnameCommand implements BotCommands {
    public String getCommand() {
        return "!botname";
    }

    public Boolean getIsAdminCommand() {
        return true;
    }

    public void execute(Donaldtrump dt, User u, List<String> args, TextMessageEvent textMessageEvent, ClientInfo invokerClient) {
        String newName = StringUtils.join(args, " ");
        dt.getApi().setNickname(newName);
    }
}
