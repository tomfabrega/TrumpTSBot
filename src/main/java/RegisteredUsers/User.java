package RegisteredUsers;

import Flags.Flags;

import java.util.ArrayList;

public class User {

    String LastKnownName;
    String UniqueIdentifier;
    ArrayList<Flags> flags = new ArrayList<Flags>();

    public String getLastKnownName() {
        return LastKnownName;
    }

    public void setLastKnownName(String lastKnownName) {
        LastKnownName = lastKnownName;
    }

    public String getUniqueIdentifier() {
        return UniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        UniqueIdentifier = uniqueIdentifier;
    }

    public ArrayList<Flags> getFlags() {
        return flags;
    }

    public void setFlags(ArrayList<Flags> flags) {
        this.flags = flags;
    }


}
