package BotCommands;

import Bot.Donaldtrump;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

import java.util.List;

public class AdminCommand implements BotCommands {

    final String command = "!admin";

    public String getCommand() {
        return command;
    }

    public Boolean getIsAdminCommand() {
        return false;
    }

    public void execute(Donaldtrump dt, User u, List<String> args, TextMessageEvent textMessageEvent, ClientInfo invokerClient) {
        int clientId = dt.getApi().getClientByUId(u.getUniqueIdentifier()).getId();
        dt.getApi().sendPrivateMessage(clientId, "Hier findest du alle Bot-Befehle, die dir zur Verfügung stehen:");
        for (BotCommands b: dt.getBotCommands()
             ) {
            dt.getApi().sendPrivateMessage(clientId, b.getCommand());
        }
        dt.getApi().sendServerMessage("Test Nachricht");
    }
}
