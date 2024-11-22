public class Game {
    public static void main(String[] args)
    {
        printInstructions();

    }
    public static void printInstructions()
    {
        String info = """
                 _______       .-''-.      .-''-.  .---.  .---..-./`) ,---.  ,---.   .-''-.  \s
                \\  ____  \\   .'_ _   \\   .'_ _   \\ |   |  |_ _|\\ .-.')|   /  |   | .'_ _   \\ \s
                | |    \\ |  / ( ` )   ' / ( ` )   '|   |  ( ' )/ `-' \\|  |   |  .'/ ( ` )   '\s
                | |____/ / . (_ o _)  |. (_ o _)  ||   '-(_{;}_)`-'`"`|  | _ |  |. (_ o _)  |\s
                |   _ _ '. |  (_,_)___||  (_,_)___||      (_,_) .---. |  _( )_  ||  (_,_)___|\s
                |  ( ' )  \\'  \\   .---.'  \\   .---.| _ _--.   | |   | \\ (_ o._) /'  \\   .---.\s
                | (_{;}_) | \\  `-'    / \\  `-'    /|( ' ) |   | |   |  \\ (_,_) /  \\  `-'    /\s
                |  (_,_)  /  \\       /   \\       / (_{;}_)|   | |   |   \\     /    \\       / \s
                /_______.'    `'-..-'     `'-..-'  '(_,_) '---' '---'    `---`      `'-..-'""";
        info +="""
                        
                        --------------------------------------------------------------------------------------
                        This is a game called beehive. 
                        There is a pile of 10 cards, all face up, but only one is showing.
                        This is your beehive. 
                        There are two rows of three face up cards.
                        These are your flowers. 
                        Go through the game by sending bees to the flower garden, creating sets of four cards.
                        --------------------------------------------------------------------------------------""";
        System.out.println(info);

    }
}
