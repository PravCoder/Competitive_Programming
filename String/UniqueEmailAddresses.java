import java.util.ArrayList;

class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {

        ArrayList<String> addresses = new ArrayList<String>();

        for (int i=0; i<emails.length; i++) {
            String curEmail = emails[i];
            String localName = curEmail.substring(0, curEmail.indexOf("@"));
            String emailAddress = curEmail.substring(curEmail.indexOf("@"));

            if (localName.contains("+") == true) {
                localName = localName.substring(0, localName.indexOf("+"));
            }
            System.out.println("local: " + localName);
            if (localName.contains(".") == true) {
                String newLocal = "";
                for (int j=0; j<localName.length(); j++) {
                    if (localName.charAt(j) != '.') {
                        newLocal += localName.charAt(j);
                    }
                }
                localName = newLocal;
            }
            System.out.println("local: " + localName);
            System.out.println("nlocal: " + localName);
            System.out.println("------");

            String totalAddress = localName+ emailAddress;
            if (addresses.contains(totalAddress) == false) {
                //System.out.println(totalAddress);
                addresses.add(totalAddress);
            }
        }

        return addresses.size();
        
    }
}