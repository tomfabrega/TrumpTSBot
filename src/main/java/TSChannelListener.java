import Flags.Flags;
import Flags.isMexican;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.api.event.*;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

public class TSChannelListener implements TS3Listener {
    final Donaldtrump dt;
    public TSChannelListener(Donaldtrump dt) {
        this.dt = dt;
    }

    public void onTextMessage(TextMessageEvent textMessageEvent) {

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
        if (client.getChannelId() == dt.getApi().getChannelByNameExact("Mexico",true).getId()) {
            Flags flag = new isMexican();
            dt.SetUserFlag(u, flag);
        }
        if (client.getChannelId() == dt.getApi().getChannelByNameExact("USA",true).getId()) {
            dt.CheckForIllegalMexican(u,clientID);
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
