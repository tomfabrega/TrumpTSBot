import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.reconnect.ConnectionHandler;
import com.github.theholywaffle.teamspeak3.api.reconnect.ReconnectStrategy;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;
import com.github.theholywaffle.teamspeak3.api.wrapper.ServerGroup;

public class Donaldtrump {

    public static void main(String[] args) {

        final BotSettings botSetting = new BotSettings();

        final TS3Config config = new TS3Config();
        config.setHost(botSetting.getHost());

        final TS3Query query = new TS3Query(config);
        query.connect();

        final TS3Api api = query.getApi();
        api.login(botSetting.getUsername(), botSetting.getPassword());
        api.selectVirtualServerById(1);
        api.setNickname("Donald J. Trump 2");
        api.sendChannelMessage("PutPutBot is online!");
    }
}