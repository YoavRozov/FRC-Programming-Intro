import java.util.HashMap;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.Command;

public final class SBManager {
    private static HashMap<String, GenericEntry> hmEntries = new HashMap<String, GenericEntry>();

    public static void addEntry(String tabName, String layoutName, String entryName) {
        addEntry(tabName, layoutName, entryName, 0.0);
    }

    public static void addEntry(String tabName, String layoutName, String entryName, double defaultValue) {
        ShuffleboardTab debugTab = Shuffleboard.getTab(tabName);
        ShuffleboardLayout layout = debugTab.getLayout(layoutName, BuiltInLayouts.kList);
        String keyName = tabName+"/"+layoutName+"/"+entryName;
        hmEntries.put(keyName, layout.add(entryName, defaultValue).getEntry());
    }

    public static void addEntry(String tabName, String layoutName, String... entryNames) {
        for(String entryName : entryNames) {
            addEntry(tabName, layoutName, entryName);
        }
    }

    public static void setEntry(String tabName, String layoutName, String entryName, double value) {
        String keyName = tabName+"/"+layoutName+"/"+entryName;
        hmEntries.get(keyName).setDouble(value);
    }

    public static double getEntry(String tabName, String layoutName, String entryName) {
        String keyName = tabName+"/"+layoutName+"/"+entryName;
        return hmEntries.get(keyName).getDouble(0.0);
    }

    public static double[] getEntry(String tabName, String layoutName, String... entryNames) {
        double[] values = new double[entryNames.length];
        for(int i = 0; i < entryNames.length; i++) {
            values[i] = getEntry(tabName, layoutName, entryNames[i]);
        }
        return values;
    }

    public static HashMap<String, Double> getEntriesHashMap(String tabName, String layoutName, String... entryNames) {
        HashMap<String, Double> values = new HashMap<String, Double>();
        for(String entryName : entryNames) {
            values.put(entryName, getEntry(tabName, layoutName, entryName));
        }
        return values;
    }

    // Add a clickable button inside the shuffle board to start the debug command
    public static void addCommand(Command command, String tabName, String layoutName) {
        ShuffleboardTab debugTab = Shuffleboard.getTab(tabName);
        ShuffleboardLayout layout = debugTab.getLayout(layoutName, BuiltInLayouts.kList);
        layout.add(command);
    }
}