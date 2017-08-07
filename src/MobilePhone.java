import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> list;

    public MobilePhone() {
        this.list = new ArrayList<Contacts>();
    }

    public ArrayList<Contacts> getList() {
        return list;
    }

    public boolean addContact(String name, String phoneNum) {
        if (onFile(name)) {
            return false;
        }

        this.list.add(new Contacts(name, phoneNum));
        return true;
    }

    public boolean removeContact(String name) {
        if (onFile(name)) {
            this.list.remove(getIndex(name));
            return true;
        }

        return false;
    }

    public boolean modifyNameContact(String oldName, String newName) {
        if (onFile(oldName)) {
            int index = getIndex(oldName);
            this.list.get(index).setName(newName);
            return true;
        }

        return false;
    }

    public boolean modifyFullContact(String oldName, String newName,
                                     String newPhoneNum) {
        if (onFile(oldName)) {
            int index = getIndex(oldName);
            this.list.set(index, new Contacts(newName, newPhoneNum));
            return true;
        }

        return false;
    }

    public boolean queryContact(String name) {
        if (onFile(name)) {
            return true;
        }

        return false;
    }

    public void printContactList() {
        for(int i=0; i<list.size(); i++) {
            System.out.println((i+1) + ".Name: " + list.get(i).getName()
                    + "\nTelephone number: " + list.get(i).getPhoneNumber());
        }
    }

    private int getIndex(String name) {
        for(int i=0; i<list.size(); i++) {
            String contactName = list.get(i).getName();
            if(contactName.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    private boolean onFile(String name) {
        for(int i=0; i<list.size(); i++) {
            String contactName = list.get(i).getName();
            if(contactName.equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }

}