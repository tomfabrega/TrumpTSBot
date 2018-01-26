import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Donaldtrump {


        //Allgemeine Variablen
        final Donaldtrump dt = this;
        BotSettings botSetting;

    {
        try {
            botSetting = readBotSettings();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    final TS3Config config = new TS3Config();
        final TS3Query query = new TS3Query(config);

    final TS3Api api = query.getApi();


    public void run() {
        config.setHost(botSetting.getHost());
        query.connect();
        api.login(botSetting.getUsername(), botSetting.getPassword());
        api.selectVirtualServerById(botSetting.getServerId());
        api.setNickname(botSetting.getBotname());
        api.registerAllEvents();
        api.addTS3Listeners(new TSChannelListener(dt));


        /*
        try {
            WriteInitialBotSetting(botSetting);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
*/
    }




    public void addRegisteredUser(String invokerUniqueId){
        if (getBotSetting().getRegisteredUsers().contains(invokerUniqueId)){}
        else {
            botSetting.getRegisteredUsers().add(invokerUniqueId);
            try {
                writeBotSettings();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static BotSettings readBotSettings() throws FileNotFoundException {
        XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream("BotSettings.xml")));
        BotSettings decodedBotSettings = (BotSettings) d.readObject();
        d.close();
        return decodedBotSettings;
    }

    private void writeBotSettings() throws FileNotFoundException {
        XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("BotSettings.xml")));
        e.writeObject(botSetting);
        e.close();
    }

    private static void WriteInitialBotSetting(BotSettings botSetting) throws FileNotFoundException {
        botSetting.setBotname("Donald J. Trump Test");
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




    //Getter und Setter

    public Donaldtrump getDt() {
        return dt;
    }

    public BotSettings getBotSetting() {
        return botSetting;
    }

    public void setBotSetting(BotSettings botSetting) {
        this.botSetting = botSetting;
    }

    public TS3Config getConfig() {
        return config;
    }

    public TS3Query getQuery() {
        return query;
    }

    public TS3Api getApi() {
        return api;
    }


    public void increaseWall() {
        getBotSetting().setMauerCounter(getBotSetting().getMauerCounter() + 1);
    }

    public void CheckForMexican(String invokerUID) {
        getBotSetting().getRegisteredUsers();
    }
}