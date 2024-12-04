import java.util.HashMap;
import java.util.Map;

public class ARPProtocol {

    private Map<String, String> arpCache;

    public ARPProtocol() {
        arpCache = new HashMap<>();
    }

    public String arpRequest(String ipAddress) {
        String macAddress = "00:11:22:33:44:55";
        arpCache.put(ipAddress, macAddress);
        return macAddress;
    }

    public String getMacAddress(String ipAddress) {
        return arpCache.containsKey(ipAddress) ? arpCache.get(ipAddress) : arpRequest(ipAddress);
    }

    public static void main(String[] args) {
        ARPProtocol arpProtocol = new ARPProtocol();
        
        String ip1 = "192.168.1.1";
        System.out.println("MAC address for " + ip1 + ": " + arpProtocol.getMacAddress(ip1));
        
        String ip2 = "192.168.1.2";
        System.out.println("MAC address for " + ip2 + ": " + arpProtocol.getMacAddress(ip2));
        
        System.out.println("MAC address for " + ip1 + ": " + arpProtocol.getMacAddress(ip1));
    }
} Output
