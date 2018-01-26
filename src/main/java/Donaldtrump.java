import Flags.Flags;
import Flags.isMexican;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class Donaldtrump {


        //Allgemeine Variablen
        final Donaldtrump dt = this;
        BotSettings botSetting = new BotSettings();

    {
        try {
            //WriteInitialBotSetting(botSetting);
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




    public void addRegisteredUser(ClientInfo c){
        ArrayList<User> array = getBotSetting().getRegisteredUsers();
        String uid = c.getUniqueIdentifier();
        boolean found = false;
        for(User user: array ) {

            if (user.getUniqueIdentifier().equals(uid)) {
                if (user.getLastKnownName().equals(c.getNickname())) {
                    found = true;
                    break;
                } else {
                    found = true;
                    user.setLastKnownName(c.getNickname());
                    try {
                        writeBotSettings();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (found){}
        else {
            User newUser = new User();
            newUser.setLastKnownName(c.getNickname());
            newUser.setUniqueIdentifier(c.getUniqueIdentifier());
            array.add(newUser);
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

    public void increaseWall() {
        getBotSetting().setMauerCounter(getBotSetting().getMauerCounter() + 1);
    }

    public void CheckForMexican(String invokerUID) {
        getBotSetting().getRegisteredUsers();
    }

    public void SetUserFlag(User u, Flags flag) {
        boolean alreadySet = CheckIfFlagIsAlreadySet(flag, u);
        if (alreadySet){}
        else {
            u.getFlags().add(flag);
            try {
                writeBotSettings();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean CheckIfFlagIsAlreadySet(Flags flag, User u) {
        boolean r = false;
        for (Flags f: u.getFlags()
                ) {if (f.getFlagName().equals(flag.getFlagName())){r = true; break;}
        else {r = false;}

        }
        return r;
    }

    public User getRegisteredUser(ClientInfo client) {
        User user = null;
        for (User u: getBotSetting().getRegisteredUsers()) {
            if (u.getUniqueIdentifier().equals(client.getUniqueIdentifier())){
                user= u;
                break;
            }

        }
        return user;
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


    public void CheckForIllegalMexican(User u, int invokerId) {
        int channelIdUSA = api.getChannelByNameExact("USA",true).getId();
        int channelIdMexico = api.getChannelByNameExact("Mexico",true).getId();
        if (CheckIfFlagIsAlreadySet(new isMexican(), u)){
            api.sendPrivateMessage(invokerId, "Du bist ein Tacofresser. Der 45. Präsident der USA hat entschieden, dass du nicht auf direktem Weg einreisen darfst. Für die Einreise benötigtst du Passierschein A38. Bitte wende dich an die zuständige Behörde.");
            api.moveClient(invokerId, channelIdMexico);
        }
    }
}