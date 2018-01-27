package Bot;
 import Flags.Flags;
import Flags.a38;
import Flags.isMexican;
import RegisteredUsers.User;
 import com.github.theholywaffle.teamspeak3.api.TextMessageTargetMode;
 import com.github.theholywaffle.teamspeak3.api.event.*;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

public class TSChannelListener implements TS3Listener {
    final Donaldtrump dt;


    public TSChannelListener(Donaldtrump dt) {
        this.dt = dt;
    }

    public void onTextMessage(TextMessageEvent textMessageEvent) {
        System.out.println("Listener IN: "+System.currentTimeMillis());
        final int dtClientId = dt.getApi().whoAmI().getId();
        if (textMessageEvent.getTargetMode() == TextMessageTargetMode.CLIENT && dtClientId != textMessageEvent.getInvokerId()){
            dt.CheckForCommand(textMessageEvent);
            System.out.println("Listener OUT: "+System.currentTimeMillis());
        }

    }

    public void onClientJoin(ClientJoinEvent clientJoinEvent) {


    }

    public void onClientLeave(ClientLeaveEvent clientLeaveEvent) {

    }

    public void onServerEdit(ServerEditedEvent serverEditedEvent) {

    }

    public void onChannelEdit(ChannelEditedEvent channelEditedEvent) {

    }

    public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent channelDescriptionEditedEvent) {

    }

    public void onClientMoved(ClientMovedEvent clientMovedEvent) {
        Integer clientID = clientMovedEvent.getClientId();
        String invokerUID = dt.getApi().getClientInfo(clientID).getUniqueIdentifier();
        ClientInfo client = dt.getApi().getClientInfo(clientID);
        dt.addRegisteredUser(client);
        User u = dt.getRegisteredUser(client);

        if (client.getChannelId() == dt.getApi().getChannelByNameExact("Mexico", true).getId()) {
            Flags flag = new isMexican();
            dt.SetUserFlag(u, flag);
        }
        else if (client.getChannelId() == dt.getApi().getChannelByNameExact("USA", true).getId()) {
            dt.checkForFlags("isMexican", client, 0);
            dt.checkForFlags("a38", client,0);
        }
        else if (client.getChannelId() == dt.getApi().getChannelByNameExact("Einwanderungsbehörde", true).getId()) {
            dt.checkForFlags("isMexican", client, 1);
        }
        else if (client.getChannelId() == dt.getApi().getChannelByNameExact("Phillips West Side Ghetto Keller", true).getId()){
            Flags flag = new a38();
            dt.SetUserFlag(u,flag);
        }
        else if (client.getChannelId() == dt.getApi().getChannelByNameExact("Champions League", true).getId()) {
            dt.checkForFlags("a38", client, 1);
        }
        else if (client.getChannelId() == dt.getApi().getChannelByNameExact("Hänchen", true).getId()) {
            dt.checkForFlags("a38", client, 2);
        }
        else if (client.getChannelId() == dt.getApi().getChannelByNameExact("Raper of Hoes", true).getId()) {
            dt.checkForFlags("a38", client, 3);
        }
        else if (client.getChannelId() == dt.getApi().getChannelByNameExact("Idle", true).getId()) {
            dt.checkForFlags("a38", client, 4);
        }
        else if (client.getChannelId() == dt.getApi().getChannelByNameExact("Lobby", true).getId()) {
            dt.checkForFlags("a38", client, 5);
        }


    }

    public void onChannelCreate(ChannelCreateEvent channelCreateEvent) {

    }

    public void onChannelDeleted(ChannelDeletedEvent channelDeletedEvent) {

    }

    public void onChannelMoved(ChannelMovedEvent channelMovedEvent) {


    }

    public void onChannelPasswordChanged(ChannelPasswordChangedEvent channelPasswordChangedEvent) {

    }

    public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent privilegeKeyUsedEvent) {

    }

}
