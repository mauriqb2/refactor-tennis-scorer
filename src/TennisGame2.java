
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (isAll())
            score = getAll();
            
        if (isDeuce())
            score = getDeuce();
        
        if (isLove())
            score = getLiteralScore();
        
        if (isNormal())
            score = getLiteralScore();
        
        if (isAdvantage())
        	score = getAdvantage();
        
        if (isWin())
        	score = getWin();
        
        return score;
    }

	private String getAll() {
		return getLiteral(P1point) + "-All";
	}

	private String getDeuce() {
		return "Deuce";
	}

	private String getLiteralScore() {
		return getLiteral(P1point) + "-" + getLiteral(P2point);
	}

	private boolean isDeuce() {
		return P1point==P2point && P1point>=3;
	}

	private boolean isNormal() {
		return P1point>P2point && P1point < 4 || P2point>P1point && P2point < 4;
	}

	private boolean isAll() {
		return P1point == P2point && P1point < 4;
	}

	private boolean isLove() {
		return P1point > 0 && P2point==0 || P2point > 0 && P1point==0;
	}

	private String getLiteral(int playerPoint) {
		String literal="";
		if (playerPoint==0)
			literal = "Love";
		if (playerPoint==1)
		    literal = "Fifteen";
		if (playerPoint==2)
		    literal = "Thirty";
		if (playerPoint==3)
		    literal = "Forty";
		return literal;
	}

	private String getAdvantage() {
		String score = "";
		if (hasFirstAdvantage(P1point, P2point))
        {
            score = "Advantage player1";
        }
        
        if (hasFirstAdvantage(P2point, P1point))
        {
            score = "Advantage player2";
        }
		return score;
	}

	private boolean hasFirstAdvantage(int playerOne, int playerTwo) {
		return playerOne > playerTwo && playerTwo >= 3;
	}
	
	private boolean isAdvantage() {
		return (P1point > P2point && P2point >= 3) || (P2point > P1point && P1point >= 3);
	}

	private String getWin() {
		String score = "";
		if (isfirstWinner(P1point, P2point))
        {
            score = "Win for player1";
        }
        if (isfirstWinner(P2point, P1point))
        {
            score = "Win for player2";
        }
		return score;
	}

	private boolean isfirstWinner(int playerOne, int playerTwo) {
		return playerOne>=4 && playerTwo>=0 && (playerOne-playerTwo)>=2;
	}
	
	private boolean isWin() {
		return (P1point>=4 && P2point>=0 && (P1point-P2point)>=2) || (P2point>=4 && P1point>=0 && (P2point-P1point)>=2);
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}