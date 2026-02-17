/*
 * Problem 2.3.1 Sell My Pet Food
 */
public class TargetedAd {

    /*  
     * TODO:
     * PREPARATION WORK
     * (1) Create a file called targetWords.txt. Populate this file with words on each line that
     *     you think would determine if a user is a dog or cat owner.
     * 
     * PROGRAMMING
     * (2) Create a new DataCollector object and set the data to "socialMediaPostsSmall.txt" and "targetWords.txt"
     *     Important: Use the socialMedialPostsSmall to create your algorithm. Using a small file will help you 
     *     generate your solution quicker and give you the ability to double check your work.
     * (3) Create a String variable to hold the names of all the user. (The first word of every post is 
     *     a person's username)
     * (4) Compare each user's post to each target word. If a user mentions a target word, add their username to 
     *     the String of users. Separate usernames with a space. 
     *         Hint: You can use loops to look through each word. 
     *         Hint2: You can use indexOf to check if a word is in a user post. 
     * (5) Once you have all the users, use your DataCollector's prepareAdvertisement method to prepare a file 
     *     with all users and the advertisement you will send them.
     *         Additional Info: The prepareAdvertisement creates a new file on your computer. Check the posts of
     *         some of the usernames to make sure your algorithm worked.
     * 
     * THE FINAL SOLUTION
     * (6) Your solution should work with the socialMedialPostsSmall.txt. Modify your DataCollector initialization
     *    so you use the socialMediaPosts.txt. You should now have a larger file of users to target.
     */

  public static void main(String[] args)
  {
    DataCollector dc = new DataCollector();
    dc.setData("socialMediaPosts.txt", "targetWords.txt");
    
    String targetedUsers = "";
    String post = dc.getNextPost();
    int postsScanned = 0;
    int matchesFound = 0;

    boolean mentionsDonkey = false;

    while (!post.equals("NONE"))
    {
      postsScanned++;
      String username = post.substring(0, post.indexOf(" "));
      String lowerPost = post.toLowerCase();

      if (lowerPost.contains("donkey") || lowerPost.contains("donkeys") {
        mentionsDonkey = true;
      }

      String targetWord = dc.getNextTargetWord();
      boolean found = false;

      while (!targetWord.equals("NONE"))
      {
        if (lowerPost.indexOf(targetWord.toLowerCase()) != -1)
        {
          found = true;
        }
        targetWord = dc.getNextTargetWord();
      }

      if (found) {
        if (!targetedUsers.contains(username + " ")) {
          targetedUsers += username + " ";
          matchesFound++;
        }
      }

      post = dc.getNextPost();
    }

    String advertisement;

    if (mentionsDonkey) {
      advertisement = "Your furry friend will love our donkey food!";
    } else {
      advertisement = "Your furry friend will love our pet food!";
    }

    dc.prepareAdvertisement("targetedAds.txt", targetedUsers.trim(), advertisement);

    // simple CSA-level print statements
    System.out.println("Scanning complete.");
    System.out.println("Posts checked: " + postsScanned);
    System.out.println("Users found: " + matchesFound);
    System.out.println("Advertisement file created.");
    System.out.println("Message sent: " + advertisement);
  }

}
