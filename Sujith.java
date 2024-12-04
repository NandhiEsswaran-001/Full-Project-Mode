import java.util.HashMap;
import java.util.Map;

class ARPServer {
    private Map<String, String> arpTable;

    public ARPServer() {
        arpTable = new HashMap<>();
        arpTable.put("192.168.1.1", "00:1A:28:3C:4D:5E");
        arpTable.put("192.168.1.2", "00:1A:28:3C:4D:5F");
    }

    public String resolveIP(String ipAddress) {
        return arpTable.getOrDefault(ipAddress, "Not Found");
    }
}

class ARPClient {
    private ARPServer server;

    public ARPClient(ARPServer server) {
        this.server = server;
    }

    public void sendRequest(String ipAddress) {
        String macAddress = server.resolveIP(ipAddress);
        if (!macAddress.equals("Not Found")) {
            System.out.println("IP " + ipAddress + " is resolved to MAC " + macAddress);
        } else {
            System.out.println("IP " + ipAddress + " not found in ARP table.");
        }
    }
}

public class SimpleARPSimulation {
    public static void main(String[] args) {
        ARPServer server = new ARPServer();
        ARPClient client = new ARPClient(server);
        client.sendRequest("192.168.1.1");
        client.sendRequest("192.168.1.3");
    }
}import java.util.HashMap;
import java.util.Map;

class ARPServer {
    private Map<String, String> arpTable;

    public ARPServer() {
        arpTable = new HashMap<>();
        arpTable.put("192.168.1.1", "00:1A:28:3C:4D:5E");
        arpTable.put("192.168.1.2", "00:1A:28:3C:4D:5F");
    }

    public String resolveIP(String ipAddress) {
        return arpTable.getOrDefault(ipAddress, "Not Found");
    }
}

class ARPClient {
    private ARPServer server;

    public ARPClient(ARPServer server) {
        this.server = server;
    }

    public void sendRequest(String ipAddress) {
        String macAddress = server.resolveIP(ipAddress);
        if (!macAddress.equals("Not Found")) {
            System.out.println("IP " + ipAddress + " is resolved to MAC " + macAddress);
        } else {
            System.out.println("IP " + ipAddress + " not found in ARP table.");
        }
    }
}

public class SimpleARPSimulation {
    public static void main(String[] args) {
        ARPServer server = new ARPServer();
        ARPClient client = new ARPClient(server);
        client.sendRequest("192.168.1.1");
        client.sendRequest("192.168.1.3");
    }
}
