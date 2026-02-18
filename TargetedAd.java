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

  private static String[] adCampaigns = {
    "[PREMIUM PASTURE PLUS] Tired of picky eaters? Our fiber-rich blend keeps donkeys satisfied! Vet-approved. 20% OFF first order! Use code: HEEHAW20",
    "[HEEHAW HARVEST] All-natural, low-sugar pellets for donkey metabolism. No fillers. No additives. FREE SHIPPING $50+! Shop now at DonkeyDelights.com",
    "[BURROBYTES TREATS] Training treats that WORK! Apple & carrot bites, perfect size. BUY 2 GET 1 FREE! Limited time only!",
    "[SENIOR DONKEY GOLD] Gentle nutrition for aging companions. Easy-chew pellets + joint support. Subscribe & save 15%! Your donkey deserves it.",
    "[WORKMULE PRO] High-energy formula for hardworking equines. Sustained carbs + electrolytes. FUEL THE WORK! Order: 1-800-DONK-FOOD",
    "[ORGANIC MEADOW MUNCH] USDA Certified Organic. Non-GMO. Pesticide-free. Clean eating for four-legged friends! Use code: ORGANIC25"
  };

  public static void main(String[] args)
  {
    System.out.println("\n" + "=".repeat(50));
    System.out.println("    DONKEY FOOD TARGETED AD SYSTEM v2.0");
    System.out.println("  \"Making donkeys happy, one pellet at a time\"");
    System.out.println("=".repeat(50) + "\n");

    DataCollector dc = new DataCollector();
    dc.setData("socialMediaPosts.txt", "targetWords.txt");
    
    String targetedUsers = "";
    String post = dc.getNextPost();
    int postsScanned = 0;
    int matchesFound = 0;

    System.out.println("[*] Scanning social media posts...");

    while (!post.equals("NONE"))
    {
      postsScanned++;
      String username = post.substring(0, post.indexOf(" "));
      String lowerPost = post.toLowerCase();

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

      if (found && targetedUsers.indexOf(username) == -1)
      {
        targetedUsers += username + " ";
        matchesFound++;
      }

      post = dc.getNextPost();
    }

    int randomIndex = (int)(Math.random() * adCampaigns.length);
    String advertisement = adCampaigns[randomIndex];

    dc.prepareAdvertisement("targetedAds.txt", targetedUsers.trim(), advertisement);

    System.out.println("[+] Scan complete!\n");
    System.out.println("-".repeat(50));
    System.out.println("CAMPAIGN STATS:");
    System.out.println("-".repeat(50));
    System.out.println("  Posts scanned:     " + postsScanned);
    System.out.println("  Users targeted:    " + matchesFound);
    System.out.println("  Ad campaign used:  #" + (randomIndex + 1));
    System.out.println("  Output file:       targetedAds.txt");
    System.out.println("-".repeat(50));
    System.out.println("\nAD PREVIEW:");
    System.out.println("  " + advertisement);
    System.out.println("\n[SUCCESS] Advertisement file created!");
  }

}
