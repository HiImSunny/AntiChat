package me.sunny.rbantichat;

import java.util.Random;
import java.util.regex.Pattern;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class EventsManager {
	
	public static void onParticles1(Player p) {
		p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 50000F, 1F);
		p.spawnParticle(Particle.MOB_APPEARANCE, p.getLocation(), 50, 0.5, 0.5, 0.5, 0.5);
		p.spawnParticle(Particle.VILLAGER_ANGRY, p.getLocation(), 50, 2.0, 2.0, 2.0, 2.0);
		p.spawnParticle(Particle.VILLAGER_HAPPY, p.getLocation(), 50, 2.0, 2.0, 2.0, 2.0);
		p.spawnParticle(Particle.NOTE, p.getLocation(), 60, 2.0, 2.0, 2.0, 2.0);
	}
	
	public static void onParticles2(Player p) {
		p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 50000F, 1F);
		p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 50000F, 1F);
		p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_FALL, 50000F, 1F);
		p.playSound(p.getLocation(), Sound.ENTITY_DONKEY_DEATH, 50000F, 1F);
		p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 50000F, 1F);
		p.spawnParticle(Particle.MOB_APPEARANCE, p.getLocation(), 50, 0.5, 0.5, 0.5, 0.5);
		p.spawnParticle(Particle.VILLAGER_ANGRY, p.getLocation(), 50, 2.0, 2.0, 2.0, 2.0);
		p.spawnParticle(Particle.VILLAGER_HAPPY, p.getLocation(), 50, 2.0, 2.0, 2.0, 2.0);
		p.spawnParticle(Particle.NOTE, p.getLocation(), 60, 2.0, 2.0, 2.0, 2.0);
	}
	

	private static String tldRegex = "AC|ACADEMY|ACCOUNTANTS|ACTOR|AD|AE|AERO|AF|AG|AGENCY|AI|AIRFORCE|AL|AM|AN|AO|AQ|AR|ARCHI|ARPA|AS|ASIA|ASSOCIATES|AT|AU|AW|AX|AXA|AZ|BA|BAR|BARGAINS|BAYERN|BB|BD|BE|BERLIN|BEST|BF|BG|BH|BI|BID|BIKE|BIZ|BJ|BLACK|BLACKFRIDAY|BLUE|BM|BN|BO|BOUTIQUE|BR|BS|BT|BUILD|BUILDERS|BUZZ|BV|BW|BY|BZ|CA|CAB|CAMERA|CAMP|CAPITAL|CARDS|CARE|CAREER|CAREERS|CASH|CAT|CATERING|CC|CD|CENTER|CEO|CF|CG|CH|CHEAP|CHRISTMAS|CI|CITIC|CK|CL|CLAIMS|CLEANING|CLINIC|CLOTHING|CLUB|CM|CN|CO|CODES|COFFEE|COLLEGE|COLOGNE|COM|COMMUNITY|COMPANY|COMPUTER|CONDOS|CONSTRUCTION|CONSULTING|CONTRACTORS|COOKING|COOL|COOP|COUNTRY|CR|CREDIT|CREDITCARD|CRUISES|CU|CV|CW|CX|CY|CZ|DANCE|DATING|DE|DEMOCRAT|DENTAL|DESI|DIAMONDS|DIGITAL|DIRECTORY|DISCOUNT|DJ|DK|DM|DNP|DO|DOMAINS|DZ|EC|EDU|EDUCATION|EE|EG|EMAIL|ENGINEERING|ENTERPRISES|EQUIPMENT|ER|ES|ESTATE|ET|EU|EUS|EVENTS|EXCHANGE|EXPERT|EXPOSED|FAIL|FARM|FEEDBACK|FI|FINANCE|FINANCIAL|FISH|FISHING|FITNESS|FJ|FK|FLIGHTS|FLORIST|FM|FO|FOO|FOUNDATION|FR|FROGANS|FUND|FURNITURE|FUTBOL|GA|GAL|GALLERY|GB|GD|GE|GF|GG|GH|GI|GIFT|GL|GLASS|GLOBO|GM|GMO|GN|GOP|GOV|GP|GQ|GR|GRAPHICS|GRATIS|GRIPE|GS|GT|GU|GUITARS|GURU|GW|GY|HAUS|HK|HM|HN|HOLDINGS|HOLIDAY|HORSE|HOUSE|HR|HT|HU|ID|IE|IL|IM|IMMOBILIEN|IN|INDUSTRIES|INFO|INK|INSTITUTE|INSURE|INT|INTERNATIONAL|INVESTMENTS|IO|IQ|IR|IS|IT|JE|JETZT|JM|JO|JOBS|JP|KAUFEN|KE|KG|KH|KI|KIM|KITCHEN|KIWI|KM|KN|KOELN|KP|KR|KRED|KW|KY|KZ|LA|LAND|LB|LC|LEASE|LI|LIGHTING|LIMITED|LIMO|LINK|LK|LONDON|LR|LS|LT|LU|LUXURY|LV|LY|MA|MAISON|MANAGEMENT|MANGO|MARKETING|MC|MD|ME|MEDIA|MEET|MENU|MG|MH|MIAMI|MIL|MK|ML|MM|MN|MO|MOBI|MODA|MOE|MONASH|MOSCOW|MP|MQ|MR|MS|MT|MU|MUSEUM|MV|MW|MX|MY|MZ|NA|NAGOYA|NAME|NC|NE|NET|NEUSTAR|NF|NG|NI|NINJA|NL|NO|NP|NR|NU|NYC|NZ|OKINAWA|OM|ONL|ORG|PA|PARIS|PARTNERS|PARTS|PE|PF|PG|PH|PHOTO|PHOTOGRAPHY|PHOTOS|PICS|PICTURES|PINK|PK|PL|PLUMBING|PM|PN|POST|PR|PRO|PRODUCTIONS|PROPERTIES|PS|PT|PUB|PW|PY|QA|QPON|QUEBEC|RE|RECIPES|RED|REISEN|REN|RENTALS|REPAIR|REPORT|REST|REVIEWS|RICH|RO|ROCKS|RODEO|RS|RU|RUHR|RW|RYUKYU|SA|SAARLAND|SB|SC|SCHULE|SD|SE|SERVICES|SEXY|SG|SH|SHIKSHA|SHOES|SI|SINGLES|SJ|SK|SL|SM|SN|SO|SOCIAL|SOHU|SOLAR|SOLUTIONS|SOY|SR|ST|SU|SUPPLIES|SUPPLY|SUPPORT|SURGERY|SV|SX|SY|SYSTEMS|SZ|TATTOO|TAX|TC|TD|TECHNOLOGY|TEL|TF|TG|TH|TIENDA|TIPS|TJ|TK|TL|TM|TN|TO|TODAY|TOKYO|TOOLS|TOWN|TOYS|TP|TR|TRADE|TRAINING|TRAVEL|TT|TV|TW|TZ|UA|UG|UK|UNIVERSITY|UNO|US|UY|UZ|VA|VACATIONS|VC|VE|VEGAS|VENTURES|VG|VI|VIAJES|VILLAS|VISION|VN|VODKA|VOTE|VOTING|VOTO|VOYAGE|VU|WANG|WATCH|WEBCAM|WED|WF|WIEN|WIKI|WORKS|WS|WTC|WTF|XN--3BST00M|XN--3DS443G|XN--3E0B707E|XN--45BRJ9C|XN--55QW42G|XN--55QX5D|XN--6FRZ82G|XN--6QQ986B3XL|XN--80ADXHKS|XN--80AO21A|XN--80ASEHDB|XN--80ASWG|XN--90A3AC|XN--C1AVG|XN--CG4BKI|XN--CLCHC0EA0B2G2A9GCD|XN--CZRU2D|XN--D1ACJ3B|XN--FIQ228C5HS|XN--FIQ64B|XN--FIQS8S|XN--FIQZ9S|XN--FPCRJ9C3D|XN--FZC2C9E2C|XN--GECRJ9C|XN--H2BRJ9C|XN--I1B6B1A6A2E|XN--IO0A7I|XN--J1AMH|XN--J6W193G|XN--KPRW13D|XN--KPRY57D|XN--L1ACC|XN--LGBBAT1AD8J|XN--MGB9AWBF|XN--MGBA3A4F16A|XN--MGBAAM7A8H|XN--MGBAB2BD|XN--MGBAYH7GPA|XN--MGBBH1A71E|XN--MGBC0A9AZCG|XN--MGBERP4A5D4AR|XN--MGBX4CD0AB|XN--NGBC5AZD|XN--NQV7F|XN--NQV7FS00EMA|XN--O3CW4H|XN--OGBPF8FL|XN--P1AI|XN--PGBS0DH|XN--Q9JYB4C|XN--RHQV96G|XN--S9BRJ9C|XN--SES554G|XN--UNUP4Y|XN--WGBH1C|XN--WGBL6A|XN--XKC2AL3HYE2A|XN--XKC2DL3A5EE0H|XN--YFRO4I67O|XN--YGBI2AMMX|XN--ZFR164B|XXX|XYZ|YE|YOKOHAMA|YT|ZA|ZM|ZONE|ZW";

	public static String checkForWhitelist(String str) {
		String finish = str;
		for (String whitelist : Main.getPlugin().getConfig().getStringList("Domain.whitelist")) {
			if (whitelist.startsWith("regex:")) {
				finish = finish.toLowerCase()
						.replaceAll(whitelist.toLowerCase().substring(6).replace("{tld}", getValidTLDs()), "");													
			} else {
				finish = finish.toLowerCase().replace(whitelist.toLowerCase(), "");
			}
		}
		return finish;
	}

	public static boolean checkForIp(String str) {
		String ipPattern = "([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})";
		if (Pattern.compile(ipPattern).matcher(str).find()) {
			return true;
		}
		return false;
	}

	public static boolean checkForDomain(String str) {
		String domainPattern = "([a-z-0-9]{1,50})\\.(" + getValidTLDs() + ")(?![a-z0-9])";
		if (Pattern.compile(domainPattern).matcher(str).find()) {
			return true;
		}
		return false;
	}

	public static boolean getChat(Player p, String m) {
		m = m.toLowerCase();
		m = m.replace("\n", "");
		String whitelist = checkForWhitelist(m);
		if (!whitelist.equals(m)) {
			m = whitelist;
		}
		if (checkForIp(m)) {
			return false;
		}
		if (checkForDomain(m)) {
			return false;
		}
		return true;
	}

	public static String getValidTLDs() {
		return tldRegex.toLowerCase();
	}
	
	public static String a = "abcdefghijklmnopqrstuvwxyz";
	public static String A = a.toUpperCase();
	public static String num = "0123456789";
	public static String an = a + A + num;
	
	public static Random r = new Random();
	
	public static String randomAnum(int nu) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nu; i++) {
			int n = randomNumber(0, an.length() - 1);
			char c = an.charAt(n);
			sb.append(c);
		} 
		return sb.toString();
	}
	
	public static int randomNumber(int min, int max) {
		return r.nextInt((max - min) + 1) + min;
	}

}
