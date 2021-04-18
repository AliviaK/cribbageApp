# Weekly Reflections

## Week 1 
    3 hrs setting up environment and brainstorming app details. First week of  
    classes so setting up environment and familiarizing with IntelliJ were the 
    focus points and went well.

## Week 2
     6 hrs completing weekly activities, practicing with GitHub and merging conflicts,
     creating indie project repository and pushing to GitHub, and learning debugger.

## Week 3:
    2/6 
        7:30pm - 11:00pm Reading about JUnit 5 and configuring my Laptop and
                Desktop environments completely. Finished all TODOs for
                ListTest.java but maybe need javadoc? Read about part 2
                and familiarized/got ideas.

    2/7 
        4:00pm - 10:30pm Reading more about JUnit 5 and finishing part 2 of exercise for
                week 3. Got stuck on exception testing and still have questions
                but got discovered javadoc assisting tools in IntelliJ and feel
                more confident with JUnit and TDD.
## Week 4:
    2/8
        Creating Hibernate database for cribbage app, and beginning with user object.
        Added very simple interface to search users by username or show all.
    
    2/13
        Planning for weekly division of work for all classes and project fit into work 
        schedule, and hopefully this structure wil help keep me on track and conceptualize
        what I can get done in small time frames. 
    
    2/14
        Completed the addition of the User DAO in my indie project with relative ease. 
        Will be doing more of this when I create my game database.
## Week 5:
    2/15
        Followed videos 1 and 2 of this week, and created a Games table in my test database
        to build the test first.

    2/19
        Troubleshooting and planning for my database and table data structures. Watched 
        more videos and finalized Games table structure.

    2/20
        Converted to GenericDao and passed all but one test for User and Game dao
        implementations. Got stuck on passing User object to game dao.

    2/21
        Passed final test and created basic jsp to view users and ids of games played.
## Week 6
    2/21
        Got an early start this week by getting through the readings and videos on Sunday.
        Deployed my cribbageapp to AWS and will be spending the rest of the 
        time before class furthering my project plan schedule and database structure.

## Week 7
    3/1
        Had a difficult week and fell behind in the exercises after nearly completing 
        exercise 6 a week ago. All but made port 8080 open to all and set the alarm for 
        reboot, which I have completed today. Submitted my reviews of peer project checkpoints
        and a peer research project on Gradle.
    3/7
        I added an admin role and granted admin access to a user I'd previously created,
        all into my project. It went smoothly as soon as I realized I didn't have the right
        realm name. Added the login button as well. Beginning to put together materials for 
        independent research topic.

## Week 8
    3/13
        Implemented DeckOfCardsAPI and it went very smoothly.

## Week 9
    3/22
        Added authentication to the project, which was successful in IntelliJ but coudln't get
        admin login to work on the deployed AWS app. Fell a bit behind in reflections and weekly work,
        but catching up. Presented my JavaFX research project.
    3/28
        My group and I decided on a "What's on Tap?" app for Madison bars. Met twice and got our 
        project plan in place. I will be creating the DAO next week.

## Week 10
    3/31
        Got my AWS admin login working finally! Forgot to add the role table to my EC2 instance, and my     
        context.xml containted the wrong login. Fell a bit behind in my weekly project plan so this week I 
        am adding the beginnings and first scene of the game. Also created the DAO for team project.
## Week 11
    4/5
        Passed new tests and made new objects for DeckOfCardsDAO to retrieve. Worked on finishing DAO tests
        for team project.
    4/6
        Created, debugged, and passed more tests for DeckOfCardsDAO. Got stuck trying to create more than one
        pile of cards as the object was mapped as a name. Deciding whether to create many objects for each pile
        or create my own objects for playerHand, CpuHand, Crib, and Cut.
    4/7
        Passed new tests for Pile creation with the API. More issues created. Will be creating my own solution 
        with my own objects.
    4/11
        Achieved 95% test coverage for team project tests and created index.jsp for our API.
## Week 12
    4/13
        Finalized materials for team project and discussed presentation, which went smoothly.
    4/15
        Worked on getting the functionality for starting a new game and dealing a new hand. Ran into an issue 
        of figuring out how to transfer selected cards to throw to crib and begain brainstorming and testing 
        potential solutions. Also created JavaScript to validate only 2 cards can be selected for crib.
    4/16
        Discovered the varStatus attribute and implemented it to be a loop counter for looping through cards in 
        player's hand. Switched hands from List<CardsItem> to Map<String, CardsItem> with the String key being 
        the card's code, so it is accessible just by knowing the value of the card itself. Finished scenes 1 and 2
    4/17
        Began creating the JSP for scene 3. Working on the functionality for a player to keep selecting only unplayed
        cards in their hand.       
        