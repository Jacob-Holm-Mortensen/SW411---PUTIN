import java.util.ArrayList;
import java.util.HashMap;

public class SymbolTableEntry {
    enum Type {Number, Text, SpecialTiles, Boolean, Player, Piece, List, Coordinate, Turn, Move, Board, Any}

    public String ID = "";
    public Type type = null;
    public HashMap<String, SymbolTableEntry> SymbolTable = new HashMap<String, SymbolTableEntry>();
    public ArrayList<SymbolTableEntry> inputs = new ArrayList<SymbolTableEntry>();
}