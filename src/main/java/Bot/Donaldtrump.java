package Bot;

import BotCommands.*;
import Flags.Flags;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

public class Donaldtrump {


    //Allgemeine Variablen
    final Donaldtrump dt = this;
    BotSettings botSetting = new BotSettings();
    ArrayList<BotCommands> botCommands = new ArrayList<BotCommands>();

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
        registerAllBotCommands();


/*
        try {
            WriteInitialBotSetting(botSetting);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
*/
    }

    private void registerAllBotCommands() {
        getBotCommands().add(new AdminCommand());
        getBotCommands().add(new BotnameCommand());
        getBotCommands().add(new AddAdminCommand());
        getBotCommands().add(new RegisterAsAdminCommand());
        getBotCommands().add(new MuteCommand());
    }


    public void addRegisteredUser(ClientInfo c) {
        ArrayList<User> array = getBotSetting().getRegisteredUsers();
        String uid = c.getUniqueIdentifier();
        boolean found = false;
        for (User user : array) {

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
        if (found) {
        } else {
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



    //read and write Bot Settings
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




    public void SetUserFlag(User u, Flags flag) {
        boolean alreadySet = CheckIfFlagIsAlreadySet(flag, u);
        if (alreadySet) {
        } else {
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
        for (Flags f : u.getFlags()
                ) {
            if (f.getFlagName().equals(flag.getFlagName())) {
                r = true;
                break;
            } else {
                r = false;
            }

        }
        return r;
    }

    public User getRegisteredUser(ClientInfo client) {
        User user = null;
        for (User u : getBotSetting().getRegisteredUsers()) {
            if (u.getUniqueIdentifier().equals(client.getUniqueIdentifier())) {
                user = u;
                break;
            }

        }
        return user;
    }

    public void checkForFlags(String flagName, ClientInfo c, int i) {
        System.out.println("checkForFlags IN: "+System.currentTimeMillis());
        User u = getRegisteredUser(c);
        for (Flags f : u.getFlags()
                ) {
            if (f.getFlagName().equals(flagName)) {

                f.execute(this, c, i);
                try {
                    writeBotSettings();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("checkForFlags IN: "+System.currentTimeMillis());
                break;
            }
        }
    }

    public void removeFlag(String flagName, User u) {
        /*
        ArrayList<Flags> flags = u.getFlags();
        Iterator<Flags> i = flags.iterator();
        while (i.hasNext()){
            if ()
            */
        ArrayList<Flags> flags = u.getFlags();
        Flags flagToRemove = null;
        for (int j = 0; j<flags.size();j++){
            if (flags.get(j).getFlagName().equals(flagName)){flagToRemove = flags.get(j);}
        }
        flags.remove(flagToRemove);
        try {
            writeBotSettings();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void CheckForCommand(TextMessageEvent textMessageEvent) {
        ClientInfo invokerClient = dt.getApi().getClientByUId(textMessageEvent.getInvokerUniqueId());
        String message = textMessageEvent.getMessage();
        List<String> splitMessage = Arrays.asList(message.split("\\s+"));
        List<String> args = getArguments(message);
        User u = getRegisteredUser(dt.getApi().getClientByUId(textMessageEvent.getInvokerUniqueId()));
        System.out.println("checkForCommands Before LOOP: "+System.currentTimeMillis());
        for (BotCommands b: getBotCommands()
             ) {
            String cm = b.getCommand();
            if (cm.equals(splitMessage.get(0))) {
                if (b.getIsAdminCommand() && userHasFlag("isAdmin", u)) {
                    System.out.println("checkForCommands Before Exec: "+System.currentTimeMillis());
                    b.execute(dt, u, args, textMessageEvent, invokerClient);
                    System.out.println("checkForCommands After Exec: "+System.currentTimeMillis());
                }
                else if (!b.getIsAdminCommand()){
                    System.out.println("checkForCommands Before Exec: "+System.currentTimeMillis());
                    b.execute(dt, u, args, textMessageEvent, invokerClient);
                    System.out.println("checkForCommands After Exec: "+System.currentTimeMillis());
                }
                else {dt.getApi().sendPrivateMessage(textMessageEvent.getInvokerId(), "Sie sind für diesen Befehl nicht berechtigt");}
            }
        }
        System.out.println("checkForCommands After LOOP: "+System.currentTimeMillis());
    }

    private boolean userHasFlag(String flagToCheck, User u) {
        Boolean returnValue = false;
        for (Flags f : u.getFlags()
             ) {
            if (f.getFlagName().equals(flagToCheck)){returnValue = true;}
        }
        return returnValue;
    }

    private List<String> getArguments(String message) {
        List<String> args = new ArrayList<String>(Arrays.asList(message.split("\\s+")));
        args.remove(0);
        return args;
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

    public ArrayList<BotCommands> getBotCommands() {
        return botCommands;
    }

    public void setBotCommands(ArrayList<BotCommands> botCommands) {
        this.botCommands = botCommands;
    }
}