import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.reconnect.ConnectionHandler;
import com.github.theholywaffle.teamspeak3.api.reconnect.ReconnectStrategy;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;
import com.github.theholywaffle.teamspeak3.api.wrapper.ServerGroup;

import javax.swing.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Donaldtrump {




    public static void main(String[] args) throws FileNotFoundException {



        final BotSettings botSetting = deserializeBotSettings();
        //WriteInitialBotSetting(botSetting);


        final TS3Config config = new TS3Config();
        config.setHost(botSetting.getHost());

        final TS3Query query = new TS3Query(config);
        query.connect();

        final TS3Api api = query.getApi();
        api.login(botSetting.getUsername(), botSetting.getPassword());
        api.selectVirtualServerById(1);
        api.setNickname(botSetting.getBotname());
    }

    private static BotSettings deserializeBotSettings() throws FileNotFoundException {
        XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream("BotSettings.xml")));
        BotSettings decodedBotSettings = (BotSettings) d.readObject();
        d.close();
        return decodedBotSettings;
    }

    private static void WriteInitialBotSetting(BotSettings botSetting) throws FileNotFoundException {
        botSetting.setBotname("Donald J. Trump Test2");
        botSetting.setHost("localhost");
        botSetting.setBotUniqueId("EBJJmWPjiWDv26gh0U+aqDKSjK8=");
        botSetting.setServerId(1);
        botSetting.setUsername("serveradmin");
        botSetting.setPassword("LRc6aSGD");
        botSetting.setSveinUId("FiV9YrA+XrS9HGPLCBpfqbzayUs=");

        XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("BotSettings.xml")));
        e.writeObject(botSetting);
        e.close();
    }
}