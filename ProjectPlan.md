# Cribbage Application Project Plan
Segment the game into dealing, discarding, pegging, counting non-dealer hand,
counting dealer hand, counting crib, shuffling

## Database Development
- User -> ID, Username, Password, Wins, Losses (Record Calculated by 
  (wins + losses) / losses)
- CompletedGame -> User_ID, DateTime, Score, Outcome
- CurrentGame -> PlayerName, PlayerScore, CompScore, PlayerSixCardHand, 
  CompSixCardHand, PlayerHand, CompHand, PlayerBackPeg, CompBackPeg, Crib, Cut
  Deck?
  
## Game Development
- 2 Player Cribbage Application Against Computer
- Hand and Board Visible on Screen at All Times
- Screen has Text Narrator, Outputs Score Breakdown to Users
- Auto-Count Score

## Game Logic
- Create Player, Game, Deck, Card -> Value & Suit, Peg -> Back/Front
- Deal -> Finalize Hand -> Peg -> Show Player Hand -> Show Computer Hand -> 
  Show Crib -> Shuffle -> Repeat Until Victor;

## MVP
- "Start Game" -> New Game object populates w/ Player and CompPlayer objects;
- Scene 1 "Deal": 6 cards dealt per Player; discard 2 cards per Player 
  (clicking on 2 cards for discarding will highlight img) -> Click "Discard to 
  Crib" -> Crib placed to left of board for the remainder of round;
- Scene 2 "Cut": Player clicks on deck to "cut" or auto if Comp turn -> Cut is 
  drawn and placed to left for the remainder of round;
- Scene 3 "Peg": Player or Comp play card -> Take turns playing cards while 
  checking every time for points scored or if >= 31 (if points then score
  points and if @ 31 or over start from zero) -> Repeat until last card;
- Scene 4 "Count Hands": Calculate and add scores in order; Non-dealer; dealer;
  crib;
- Scene 5 "Shuffle": Reset database with a new Deal at start of step 1

## Schedule
- 2/9 - 2/14 Edit/finalize(?) site and game design documents; finish first 
  draft of user table/DAO/Hibernate
- 2/14 - 2/28 Create Player, Deck; work on site visuals
- 2/28 -