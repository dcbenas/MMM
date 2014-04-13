package com.example.hackathongame;

import java.util.Random;

public class Generator {
	
	static String[] nameDict = { "A Bao A Qu", "Abada", "Abaia", "Abbagoochie",
			"Abath", "Abere", "Abgal", "Achiyalabopa", "Achlis", "Actaeon",
			"Adar Llwch Gwin", "Adaro", "Adjule", "Adlet", "Addonexus",
			"Aegir", "Aello", "Aenotherus", "Aesir", "Vanir", "Afanc",
			"Afreet", "Agloolik", "Agta", "Kapre", "Agrippa", "Agrius", "Ahi",
			"Ahuizhotl", "Ai Toyon", "Aicha Kandicha", "Airavata", "Akamataa",
			"Akhlut", "Akki", "Akupara", "Al", "Alan", "Albastor", "Alcetaur",
			"Alchendic", "Alcyoneus", "Alecto", "Alicanto", "Alien",
			"Alifanfaron", "Alkonost", "Almas", "Aloadae", "Aloes", "Alous",
			"Alphito", "Alphyn", "Alsvid", "Amal", "Amarok", "Ambize",
			"Amduscias", "Amermait", "Amhuluk", "A-mi-kuk", "Amphithere",
			"Amphisbaena", "Anakim", "Anaskelades", "Anaye", "Ancient One",
			"Ancient Serpent", "Androsphinx", "Angboda", "Angel", "Angka",
			"Angont", "Ankou", "Aniwye", "Anjana", "Anjing Ajak", "Antaeus",
			"Antero Vipunen", "Anthropophagus", "Antigonus", "Antiphates",
			"Antukai", "Aonbarr", "Apalala", "Apep", "Apis",
			"Apocalyptic beast", "Apotamkin", "Apotharni", "Aranda", "Arassas",
			"Araxa", "Araxa Junior", "Arctophonos", "Arepyiai", "Arges",
			"Argopelter", "Argus", "Aries", "Arimaspi", "Arimbi", "Arion",
			"Arrach", "Arrak", "Arusha", "Arzshenk", "Ascapard", "Asena",
			"Ashuaps", "Asin", "Asipatra", "Aspidochelone", "Aspis", "Asrai",
			"Asterion", "Astreus", "Astrid", "Astrope", "Aswang", "Atcen",
			"Athach", "Atlas", "Audumla", "Aufhocker", "Augerino", "Aunyaina",
			"Auvekoejak", "Aswang", "Axehandle Hound", "Axex", "Ayida-Weddo",
			"Azeman", "Azi Dahaka", "Az-i-wu-gum-ki-mukh-'ti" };
	static String[] adjDict = {"afraid", "agreeable", "amused", "ancient", "angry",
			"annoyed", "anxious", "arrogant", "ashamed", "average", "awful",
			"bad", "beautiful", "better", "big", "bitter", "black", "blue",
			"boiling", "brave", "breezy", "brief", "bright", "broad", "broken",
			"bumpy", "calm", "charming", "cheerful", "chilly", "clumsy",
			"cold", "colossal", "combative", "comfortable", "confused",
			"cooing", "cool", "cooperative", "courageous", "crazy", "creepy",
			"cruel", "cuddly", "curly", "curved", "damp", "dangerous",
			"deafening", "deep", "defeated", "defiant", "delicious",
			"delightful", "depressed", "determined", "dirty", "disgusted",
			"disturbed", "dizzy", "dry", "dull", "dusty", "eager", "early",
			"elated", "embarrassed", "empty", "encouraging", "energetic",
			"enthusiastic", "envious", "evil", "excited", "exuberant", "faint",
			"fair", "faithful", "fantastic", "fast", "fat", "few", "fierce",
			"filthy", "fine", "flaky", "flat", "fluffy", "foolish", "frail",
			"frantic", "fresh", "friendly", "frightened", "funny", "fuzzy",
			"gentle", "giant", "gigantic", "good", "gorgeous", "greasy",
			"great", "green", "grieving", "grubby", "grumpy", "handsome",
			"happy", "hard", "harsh", "healthy", "heavy", "helpful",
			"helpless", "high", "hilarious", "hissing", "hollow", "homeless",
			"horrible", "hot", "huge", "hungry", "hurt", "hushed", "husky",
			"icy", "ill", "immense", "itchy", "jealous", "jittery", "jolly",
			"juicy", "kind", "large", "late", "lazy", "light", "little",
			"lively", "lonely", "long", "loose", "loud", "lovely", "low",
			"lucky", "magnificent", "mammoth", "many", "massive", "melodic",
			"melted", "mighty", "miniature", "moaning", "modern", "mute",
			"mysterious", "narrow", "nasty", "naughty", "nervous", "new",
			"nice", "nosy", "numerous", "nutty", "obedient", "obnoxious",
			"odd", "old", "orange", "ordinary", "outrageous", "panicky",
			"perfect", "petite", "plastic", "pleasant", "precious", "pretty",
			"prickly", "proud", "puny", "purple", "purring", "quaint", "quick",
			"quickest", "quiet", "rainy", "rapid", "rare", "raspy", "ratty",
			"red", "relieved", "repulsive", "resonant", "ripe", "roasted",
			"robust", "rotten", "rough", "round", "sad", "salty", "scary",
			"scattered", "scrawny", "screeching", "selfish", "shaggy", "shaky",
			"shallow", "sharp", "shivering", "short", "shrill", "silent",
			"silky", "silly", "skinny", "slimy", "slippery", "slow", "small",
			"smiling", "smooth", "soft", "solid", "sore", "sour", "spicy",
			"splendid", "spotty", "square", "squealing", "stale", "steady",
			"steep", "sticky", "stingy", "straight", "strange", "striped",
			"strong", "successful", "sweet", "swift", "tall", "tame", "tan",
			"tart", "tasteless", "tasty", "tender", "tender", "tense",
			"terrible", "testy", "thirsty", "thoughtful", "thoughtless",
			"thundering", "tight", "tiny", "tired", "tough", "tricky",
			"troubled", "ugliest", "ugly", "uneven", "upset", "uptight",
			"vast", "victorious", "vivacious", "voiceless", "wasteful",
			"watery", "weak", "weary", "wet", "whispering", "wicked", "wide",
			"wide-eyed", "witty", "wonderful", "wooden", "worried", "yellow",
			"young", "yummy", "zany"};
	
	static Random rand = new Random();
	static String name = generateName();
	static String adj1 = generateAdj();
	static String adj2 = generateAdj();
	
	public static String generateName() {
		int seed = rand.nextInt(nameDict.length + 1);
		return nameDict[seed];
	}

	public static String generateAdj() {
		int seed = rand.nextInt(adjDict.length + 1);
		return adjDict[seed];
	}
}
