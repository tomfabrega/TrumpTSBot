package BotCommands;

import Bot.Donaldtrump;
import Flags.isAdmin;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

import java.util.List;

public class AddAdminCommand implements BotCommands {
    public String getCommand() {
        return "!addadmin";
    }

    public Boolean getIsAdminCommand() {
        return true;
    }

    public void execute(Donaldtrump dt, User u, List<String> args, TextMessageEvent textMessageEvent, ClientInfo invokerClient) {
        int clientId = dt.getApi().getClientByNameExact(args.get(0),true).getId();
        ClientInfo client = dt.getApi().getClientInfo(clientId);
        User userToGetAdmin = dt.getRegisteredUser(client);
        dt.SetUserFlag(userToGetAdmin, new isAdmin());

    }
}
