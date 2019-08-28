
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
        score = all(score);
        score = deuce(score);
        
        score = love(score);
        
        score = literal(score);
        
        score = advantage(score);
        
        score = win(score);
        return score;
    }

	private String deuce(String score) {
		if (P1point==P2point && P1point>=3)
            score = "Deuce";
		return score;
	}

	private String literal(String score) {
		if (P1point>P2point && P1point < 4)
        {
			P1res = getLiteral(P1point);
            P2res = getLiteral(P2point);
            score = P1res + "-" + P2res;
        }
        if (P2point>P1point && P2point < 4)
        {
        	P2res = getLiteral(P2point);
        	P1res = getLiteral(P1point);
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String all(String score) {
		if (P1point == P2point && P1point < 4)
        {
            score = getLiteral(P1point);
            score += "-All";
        }
		return score;
	}

	private String love(String score) {
		if (P1point > 0 && P2point==0)
        {
            P1res = getLiteral(P1point);
            P2res = getLiteral(P2point);
            score = P1res + "-" + P2res;
        }
        if (P2point > 0 && P1point==0)
        {
        	P2res = getLiteral(P2point);
            P1res = getLiteral(P1point);
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String getLiteral(int playerPoint) {
		String literal="";
		if (P1point==0)
			literal = "Love";
		if (playerPoint==1)
		    literal = "Fifteen";
		if (playerPoint==2)
		    literal = "Thirty";
		if (playerPoint==3)
		    literal = "Forty";
		return literal;
	}

	private String advantage(String score) {
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

	private String win(String score) {
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