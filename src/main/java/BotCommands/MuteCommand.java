package BotCommands;

import Bot.Donaldtrump;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.api.ChannelProperty;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MuteCommand implements BotCommands
{
    public String getCommand() {
        return "!mute";
    }

    public Boolean getIsAdminCommand() {
        return false;
    }

    public void execute(Donaldtrump dt, User u, List<String> args, TextMessageEvent textMessageEvent, ClientInfo invokerClient) {
        ClientInfo invokerClientTemp = dt.getApi().getClientByUId(u.getUniqueIdentifier());
        int clientId = dt.getApi().getClientByNameExact(args.get(0),true).getId();
        ClientInfo targetClient = dt.getApi().getClientInfo(clientId);


        int channelId = invokerClientTemp.getChannelId();
        int clientDbId = targetClient.getDatabaseId();
        String permName = "i_client_talk_power";

        if (args.get(1).equals("on")){
            dt.getApi().addClientPermission(clientDbId, permName, -10, false);
        }
        else if (args.get(1).equals("off")){
            dt.getApi().deleteClientPermission(clientDbId, permName);
            Map<ChannelProperty,String> map = new HashMap<ChannelProperty, String>();

            /*
            map.put(ChannelProperty.CHANNEL_DESCRIPTION, "Test123");
            System.out.println("test");
            dt.getApi().editChannel(channelId, map);
            */

        }
}
}
