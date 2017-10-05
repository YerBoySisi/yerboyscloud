package chatbot;

public class Chatbot {
	
	private String user;
	private Topic Sisi;
	private boolean chatting;
	
	public Chatbot() {
		
		Sisi = new ChatSisi();
		user = "unknown user";
		chatting = true;
		
	}
	
	public void startTalking() {
		
		ChatbotMain.print("Welcome to our chatbot! What is your name?");
		user = ChatbotMain.getInput();
		chatting = true;
		
		while(chatting) {
			ChatbotMain.print("What topic do you need help with? You can choose from the following list: " + "spelling, " + "tense, " 
					 + "punctuation, " + "grammar, " + "suffix, " + "prefix, " + "noun, " + "verb, " + "adjective, " + "adverb, " 
					+ "pronoun, " + "proper noun");
			String response = ChatbotMain.getInput();
			
			if(Sisi.isTriggered(response)) {
				chatting = false;
				Sisi.startChatting(response);
			} else {
				ChatbotMain.print("I'm sorry, I don't understand.");
			}
			
		}
		
	}
	
}
