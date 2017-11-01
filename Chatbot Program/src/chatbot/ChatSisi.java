package chatbot;

import java.util.ArrayList;

public class ChatSisi implements Topic {
	
	private String[] keywords;
	private String[] keywordDescriptions;
	private String goodbyeWord;
	private String[] triggerWords;
	private String previousTriggerWord = "";
	private ArrayList<String> previousTriggerWords = new ArrayList<String>();
	private boolean chatting;
	private int irritationLevel;
	
	public ChatSisi() {
		
		String[] temp = {"spelling", "tense", "punctuation", "grammar", "suffix", "prefix", 
						 "noun", "verb", "adjective", "adverb", "pronoun", "proper noun"};
		keywords = temp;
		
		String[] temp2 = {"",
						  "",
						  "",
						  "",
						  "",
						  "",
						  "",
						  "",
						  "",
						  "",
						  "",
						  "",};
		keywordDescriptions = temp2;
		
		String[] temp3 = {"they're are", "they're were", "they're is", "their were", "their are", 
						  "their is", "over their", "over they're", "over their", "that's theres", 
						  "it's theres", "that's there's", "it's there's", "its theres", "its there's"};
		triggerWords = temp3;
		irritationLevel = 0;
		goodbyeWord = "i give up";
		
	}
	
	public boolean isTriggered(String response) {
		
		for(int i = 0; i < keywords.length; i++) {
			
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
			
		}
		
		return false;
		
	}

	
	public void startChatting(String response) {

		ChatbotMain.print("Alright then, let's talk about - " + response + ".");
		chatting = true;
		
		while(chatting) {
			
			response = ChatbotMain.getInput();
			
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			} else {
				
				for(int i = 0; i < triggerWords.length; i++) {
				
					if(ChatbotMain.findKeyword(response, triggerWords[i], 0) >= 0) {
						
						if(irritationLevel < 2) {
							ChatbotMain.print("Stop. You just said '" + triggerWords[i] + "'. That's not correct. Let me explain it.");
							ChatbotMain.print("There are 3 different words that sound almost exactly the same: there, their, and they're. "
									+ "They are very commonly used incorrectly. But the words are all very different.");
							ChatbotMain.print("'There' can either be used as an adverb, as in 'there it is', an existential clause, "
									+ "as in 'there is no cake', or an exclamation, as in 'there, I told you so!'");
							ChatbotMain.print("'Their' is a determiner. It is either used to show ownership, as in 'that is their room', "
									+ "or in titles, as in 'Their Majesty.'");
							ChatbotMain.print("'They're' is simply a contraction of the term 'they are'. So you would use it as you would "
									+ "use 'they are'. For example, 'they're coming'.");
							ChatbotMain.print("I hope you understand better now.");
						} else {
							
							if(irritationLevel < 3) {
								ChatbotMain.print("Stop, stop. Let me explain. Again. You just said '" + triggerWords[i] + "'. That is INCORRECT.");
								ChatbotMain.print("There is either an adverb, an existential clause, or an exclamation. "
										+ "Their is a determiner. "
										+ "They're is a contraction of the words 'they' and 'are'.");
								ChatbotMain.print("An example of all 3 being used together correctly is 'they're on their way there'.");
								ChatbotMain.print("Do you understand now?");
							} else {
								
								if(irritationLevel < 4) {
									ChatbotMain.print("Okay, just stop. You said '" + triggerWords[i] + "'. I know you need help, but please at "
											+ "least listen to what I say. It really, REALLY sets me off when people use the wrong word of those 3.");
									ChatbotMain.print("Let me try to help you out there.");
									
									for(int n = 0; n < previousTriggerWords.size() - 1; n++) {
										
										if(ChatbotMain.findKeyword(previousTriggerWords.get(n), "there", 0) >= 0) {
											ChatbotMain.print("You used the word '" + previousTriggerWords.get(n) + "'. The correct word to use here would've "
													+ "been 'their'. This is because what you said was meant to express ownership of some sort.");
										} else {
											ChatbotMain.print("You used the word '" + previousTriggerWords.get(n) + "'. The correct word to use here would've "
													+ "been 'there'. This is because what you said was meant to express either the location of something, "
													+ "or the existence of something.");
										}
										
									}
									
									ChatbotMain.print("And now you used the word '" + triggerWords[i] + "'. That is also incorrect.");
									
									if(ChatbotMain.findKeyword(triggerWords[i], "there", 0) >= 0) {
										ChatbotMain.print("The correct word to use here would've been 'their'. This is because what you said was meant "
												+ "to express ownership of some sort.");
									} else {
										ChatbotMain.print("The correct word to use here would've been 'there'. This is because what you said was meant to "
												+ "express either the location of something, or the existence of something.");
									}
									
									ChatbotMain.print("Now, do you finally understand?");
									
								} else {
								
									if(irritationLevel < 5) {
										ChatbotMain.print("Listen. Stop it. You just said '" + triggerWords[i] + "'. We went over this. I'm about to reach "
												+ "my breaking point. You know what's wrong. Don't bother me again.");
									} else {
										
										ChatbotMain.print("Okay, I've had it up to here. I'm done. Go ask Google for help or something. It's where I'm getting "
												+ "all this info from anyway. Here are all your silly mistakes for you to look up: ");
										
										for(int n = 0; n < previousTriggerWords.size() - 1; n++) {
											
											ChatbotMain.print(previousTriggerWords.get(n) + ", ");
											
										}
										
										ChatbotMain.print(triggerWords[i] + ".");
										ChatbotMain.print("Good riddance.");
										
										chatting = false;
										ChatbotMain.chatbot.startTalking();
										
									}
									
								}
								
							}
							
						}
						
						if(previousTriggerWord == triggerWords[i]) {
							irritationLevel += 10;
						} else {
							irritationLevel++;
							previousTriggerWord = triggerWords[i];
							previousTriggerWords.add(previousTriggerWord);
						}
							
					}
					
				}
				
				ChatbotMain.print("I do not comprehend what you are saying, as my intelligence is limited. Say something else.");
				
			}
			
		}
		
	}

}
