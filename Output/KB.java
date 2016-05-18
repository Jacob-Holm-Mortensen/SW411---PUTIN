import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class KB{
	public static void main(String[] args){
		Program S = new Program();
		S.begin();
	}
}

class Program{
	BoardClass Board = new BoardClass();
	ArrayList<Player> PlayerList = new ArrayList<Player>();
	ArrayList<Coordinate> IllegalTiles = new ArrayList<Coordinate>();
	ArrayList<Move> KrydsMoves = new ArrayList<Move>();
	ArrayList<Move> BolleMoves = new ArrayList<Move>();
	Player Player1 = new Player();
	Player Player2 = new Player();
	Coordinate Coord1 = new Coordinate(1.0, 1.0);
	Coordinate Coord2 = new Coordinate(1.0, 2.0);
	Coordinate Coord3 = new Coordinate(1.0, 3.0);
	Coordinate Coord4 = new Coordinate(2.0, 1.0);
	Coordinate Coord5 = new Coordinate(2.0, 2.0);
	Coordinate Coord6 = new Coordinate(2.0, 3.0);
	Coordinate Coord7 = new Coordinate(3.0, 1.0);
	Coordinate Coord8 = new Coordinate(3.0, 2.0);
	Coordinate Coord9 = new Coordinate(3.0, 3.0);
	Double TurnNumber = 0.0;
	Kryds K1 = new Kryds();
	Kryds K2 = new Kryds();
	Kryds K3 = new Kryds();
	Bolle B1 = new Bolle();
	Bolle B2 = new Bolle();
	Bolle B4 = new Bolle();

	public void begin(){
		//Board
		Board.Height = 3;
		Board.Width = 3;
		KrydsMoves.add(new Move(0.0, 0.0));
		BolleMoves.add(new Move(0.0, 0.0));
		//Setup
		Board.setPlayerList(PlayerList);
		PlayerList.add(Player1);
		Player1.Name = "Player1";
		PlayerList.add(Player2);
		Player2.Name = "Player2";
		K1.MoveList = KrydsMoves;
		K2.MoveList = KrydsMoves;
		K3.MoveList = KrydsMoves;
		B1.MoveList = BolleMoves;
		B2.MoveList = BolleMoves;
		B4.MoveList = BolleMoves;
		Player1.PieceList.add(K1);
		Player1.PieceList.add(K2);
		Player1.PieceList.add(K3);
		Player2.PieceList.add(B1);
		Player2.PieceList.add(B2);
		Player2.PieceList.add(B4);
		//WinCondition
		PrintBoard();
		while (WinCondition()){
			TurnDistribution();
			ArrayList<Integer> I = new ArrayList<Integer>();
			for (Player PL : PlayerList) {
				for (Piece PI : PL.PieceList) {
					if (PI.Coord.equals(new Coordinate(0.0, 0.0))){
						I.add(PL.PieceList.indexOf(PI));
					}
				}
				for (int i = 0; i < I.size(); i++) {
					PL.PieceList.remove(I.get(i) - i);
				}
				I = new ArrayList<Integer>();
			}
		}
	}

	// Pieces, Rules and Methods
	public void Tie(){
		System.out.print("Nobody won it is a tie!");
		Scanner in = new Scanner(System.in);
		in.next();
		System.exit(0);
	}

	public void PrintBoard(){
		System.out.print("\n");
		for (int i = 1; i <= Board.Width; i++){
			if (i == 1){
				System.out.print(" " + (i - 1) + " ");
				for (int k = 1; k <= Board.Height; k++){
					System.out.print(" " + k + " ");
				}
				System.out.print(" X \n");
			}
			System.out.print(" " + i + " ");
			for (int j = 1; j <= Board.Height; j++){
				Boolean is = false;
				for (Player PL : PlayerList) {
					for (Piece PI : PL.PieceList) {
						if (PI.Coord.equals(new Coordinate((double) i, (double) j))){
							is = true;
						}
					}
				}
				if (is){
					System.out.print("[X]");
				}
				else {
					System.out.print("[ ]");
				}
			}
			if (i == Board.Width){
				System.out.print("\n Y ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	static String Input(String type){
		String result = "";
		Scanner in = new Scanner(System.in);
		try{
			switch (type){
				case "Number" : System.out.print("Please write a number -> "); result = Double.toString(in.nextDouble()); break;
				case "Text" : System.out.print("Please write a string ->"); result = in.nextLine(); break;
			}
		}
		catch (InputMismatchException e){
			System.out.print("Wrong input, please input a " + type);
		}
		return result;
	}

	public Boolean Contains(ArrayList<Piece> PL, Piece PT){
		for (Piece P : PL) {
			if (P.getClass().equals(PT.getClass())){
				return true;
			}
		}
		return false;
	}

	public Boolean PieceCheckOne(Coordinate input){
		if (input.x > Board.Width || input.y > Board.Height){
			return false;
		}
		if (input.x < 1 || input.y < 1){
			return false;
		}
		if (IllegalTiles.contains(input)){
			return false;
		}
		return true;
	}

	public Boolean PieceCheckTwo(Coordinate input, Coordinate Coord, ArrayList<Move> MoveList){
		int DiffX = Math.abs(Coord.x - input.x);
		int DiffY = Math.abs(Coord.y - input.y);
		Boolean returnValue = false;
		for (Move M : MoveList) {
			if (!returnValue){
				returnValue = true;
				if (DiffX < M.Hmin){
					returnValue = false;
				}
				if (DiffX > M.Hmax){
					returnValue = false;
				}
				if (DiffY < M.Vmin){
					returnValue = false;
				}
				if (DiffY > M.Vmax){
					returnValue = false;
				}
			}
		}
		if (returnValue){
			return true;
		}
		else {
			return false;
		}
	}

	public class Kryds extends Piece {
	    @Override
	    public Boolean MoveTo(Coordinate input){
	        if (!PieceCheckOne(input)){
	            return false;
	        }
	        if (!PieceCheckTwo(input, Coord, MoveList)){
	            return false;
	        }
	        Coord = input;
	        return true;
	    }
	
	    @Override
	    public Boolean CanMoveTo(Coordinate input){
	        if (!PieceCheckOne(input)){
	            return false;
	        }
	        if (!PieceCheckTwo(input, Coord, MoveList)){
	            return false;
	        }
	        return true;
	    }
	
	    @Override
	    public Boolean PlaceAt(Coordinate input){
	        if (!PieceCheckOne(input)){
	            return false;
	        }
	        Coord = input;
	        return true;
	    }
	}

	public class Bolle extends Piece {
	    @Override
	    public Boolean MoveTo(Coordinate input){
	        if (!PieceCheckOne(input)){
	            return false;
	        }
	        if (!PieceCheckTwo(input, Coord, MoveList)){
	            return false;
	        }
	        Coord = input;
	        return true;
	    }
	
	    @Override
	    public Boolean CanMoveTo(Coordinate input){
	        if (!PieceCheckOne(input)){
	            return false;
	        }
	        if (!PieceCheckTwo(input, Coord, MoveList)){
	            return false;
	        }
	        return true;
	    }
	
	    @Override
	    public Boolean PlaceAt(Coordinate input){
	        if (!PieceCheckOne(input)){
	            return false;
	        }
	        Coord = input;
	        return true;
	    }
	}

	public void Action(Player P){
	Coordinate X = new Coordinate(Double.parseDouble(Input("Number")), Double.parseDouble(Input("Number")));
	while ((Board.Tiles(X).size() == 1.0)){
	X = new Coordinate(Double.parseDouble(Input("Number")), Double.parseDouble(Input("Number")));
	}
	switch (String.valueOf(TurnNumber)){
	case "1.0" : P.PieceList.get(0).PlaceAt(X);
	break;
	case "2.0" : P.PieceList.get(1).PlaceAt(X);
	break;
	case "3.0" : P.PieceList.get(2).PlaceAt(X);
	break;
	}
	}

	public void CheckWin(Player P){
	if (((((P.PieceList.get(0).CanMoveTo(Coord1) || P.PieceList.get(1).CanMoveTo(Coord1)) || P.PieceList.get(2).CanMoveTo(Coord1)) && ((P.PieceList.get(0).CanMoveTo(Coord2) || P.PieceList.get(1).CanMoveTo(Coord2)) || P.PieceList.get(2).CanMoveTo(Coord2))) && ((P.PieceList.get(0).CanMoveTo(Coord3) || P.PieceList.get(1).CanMoveTo(Coord3)) || P.PieceList.get(2).CanMoveTo(Coord3)))){
	P.Win();
	}
	if (((((P.PieceList.get(0).CanMoveTo(Coord4) || P.PieceList.get(1).CanMoveTo(Coord4)) || P.PieceList.get(2).CanMoveTo(Coord4)) && ((P.PieceList.get(0).CanMoveTo(Coord5) || P.PieceList.get(1).CanMoveTo(Coord5)) || P.PieceList.get(2).CanMoveTo(Coord5))) && ((P.PieceList.get(0).CanMoveTo(Coord6) || P.PieceList.get(1).CanMoveTo(Coord6)) || P.PieceList.get(2).CanMoveTo(Coord6)))){
	P.Win();
	}
	if (((((P.PieceList.get(0).CanMoveTo(Coord7) || P.PieceList.get(1).CanMoveTo(Coord7)) || P.PieceList.get(2).CanMoveTo(Coord7)) && ((P.PieceList.get(0).CanMoveTo(Coord8) || P.PieceList.get(1).CanMoveTo(Coord8)) || P.PieceList.get(2).CanMoveTo(Coord8))) && ((P.PieceList.get(0).CanMoveTo(Coord9) || P.PieceList.get(1).CanMoveTo(Coord9)) || P.PieceList.get(2).CanMoveTo(Coord9)))){
	P.Win();
	}
	if (((((P.PieceList.get(0).CanMoveTo(Coord1) || P.PieceList.get(1).CanMoveTo(Coord1)) || P.PieceList.get(2).CanMoveTo(Coord1)) && ((P.PieceList.get(0).CanMoveTo(Coord4) || P.PieceList.get(1).CanMoveTo(Coord4)) || P.PieceList.get(2).CanMoveTo(Coord4))) && ((P.PieceList.get(0).CanMoveTo(Coord7) || P.PieceList.get(1).CanMoveTo(Coord7)) || P.PieceList.get(2).CanMoveTo(Coord7)))){
	P.Win();
	}
	if (((((P.PieceList.get(0).CanMoveTo(Coord2) || P.PieceList.get(1).CanMoveTo(Coord2)) || P.PieceList.get(2).CanMoveTo(Coord2)) && ((P.PieceList.get(0).CanMoveTo(Coord5) || P.PieceList.get(1).CanMoveTo(Coord5)) || P.PieceList.get(2).CanMoveTo(Coord5))) && ((P.PieceList.get(0).CanMoveTo(Coord8) || P.PieceList.get(1).CanMoveTo(Coord8)) || P.PieceList.get(2).CanMoveTo(Coord8)))){
	P.Win();
	}
	if (((((P.PieceList.get(0).CanMoveTo(Coord3) || P.PieceList.get(1).CanMoveTo(Coord3)) || P.PieceList.get(2).CanMoveTo(Coord3)) && ((P.PieceList.get(0).CanMoveTo(Coord6) || P.PieceList.get(1).CanMoveTo(Coord6)) || P.PieceList.get(2).CanMoveTo(Coord6))) && ((P.PieceList.get(0).CanMoveTo(Coord9) || P.PieceList.get(1).CanMoveTo(Coord9)) || P.PieceList.get(2).CanMoveTo(Coord9)))){
	P.Win();
	}
	if (((((P.PieceList.get(0).CanMoveTo(Coord1) || P.PieceList.get(1).CanMoveTo(Coord1)) || P.PieceList.get(2).CanMoveTo(Coord1)) && ((P.PieceList.get(0).CanMoveTo(Coord5) || P.PieceList.get(1).CanMoveTo(Coord5)) || P.PieceList.get(2).CanMoveTo(Coord5))) && ((P.PieceList.get(0).CanMoveTo(Coord9) || P.PieceList.get(1).CanMoveTo(Coord9)) || P.PieceList.get(2).CanMoveTo(Coord9)))){
	P.Win();
	}
	if (((((P.PieceList.get(0).CanMoveTo(Coord3) || P.PieceList.get(1).CanMoveTo(Coord3)) || P.PieceList.get(2).CanMoveTo(Coord3)) && ((P.PieceList.get(0).CanMoveTo(Coord5) || P.PieceList.get(1).CanMoveTo(Coord5)) || P.PieceList.get(2).CanMoveTo(Coord5))) && ((P.PieceList.get(0).CanMoveTo(Coord7) || P.PieceList.get(1).CanMoveTo(Coord7)) || P.PieceList.get(2).CanMoveTo(Coord7)))){
	P.Win();
	}
	Tie();
	}

	public void TurnDistribution(){
	TurnNumber = (TurnNumber + 1.0);
	PrintBoard();
	Action(Player1);
	PrintBoard();
	Action(Player2);
	PrintBoard();
	}

	public Boolean WinCondition(){
	if ((TurnNumber == 3.0)){
	CheckWin(Player1);
	CheckWin(Player2);
	}
	return true;
	}

}