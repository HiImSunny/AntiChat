package vn.sunext.chatmanager;

import java.util.Objects;
import java.util.logging.Level;

import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.FieldAccessException;
import vn.sunext.chatmanager.commands.MainCommand;
import vn.sunext.chatmanager.functions.*;
import vn.sunext.chatmanager.listeners.ChatBlocked;
import vn.sunext.chatmanager.listeners.*;
import vn.sunext.chatmanager.managers.PathManager;

@Getter
public class ChatManager extends JavaPlugin {

	private static ChatManager plugin;

	private PathManager pathManager;

	private ColorSystem colorSystem;
	private ParticleSystem particleSystem;
	private DomainSystem domainSystem;
	private RandomSystem randomSystem;
	private WarningSystem warningSystem;
	private MuteSystem muteSystem;
	private PermissionSystem permissionSystem;
	private MessageSystem messageSystem;
	private ConfigSystem configSystem;

	@Override
	public void onEnable() {
		plugin = this;

		saveDefaultConfig();

		pathManager = new PathManager();
		pathManager.register();

		colorSystem = new ColorSystem();
		particleSystem = new ParticleSystem();
		domainSystem = new DomainSystem();
		randomSystem = new RandomSystem();
		warningSystem = new WarningSystem();
		muteSystem = new MuteSystem();
		permissionSystem = new PermissionSystem();
		messageSystem = new MessageSystem();
		configSystem = new ConfigSystem();

		registerProtocolLib();

		registerEvents();

		Objects.requireNonNull(this.getCommand("AntiChat")).setExecutor(new MainCommand());
	}

	private void registerProtocolLib() {
		ProtocolManager prm = ProtocolLibrary.getProtocolManager();
		prm.addPacketListener(new PacketAdapter(ChatManager.getInstance(), ListenerPriority.NORMAL,
				PacketType.Play.Client.TAB_COMPLETE) {
			public void onPacketReceiving(PacketEvent event) {
				if (event.getPacketType() == PacketType.Play.Client.TAB_COMPLETE) {
					try {
						if (event.getPlayer().hasPermission("rbantichat.admin") || event.getPlayer().isOp())
							return;
						PacketContainer packet = event.getPacket();
						String message = packet.getSpecificModifier(String.class).read(0).toLowerCase();

						if (message.startsWith("/") && !message.contains(" ")) {
							event.setCancelled(true);
						}
					} catch (FieldAccessException e) {

						ChatManager.getInstance().getLogger().log(Level.SEVERE, "Couldn't access field.", e);
					}
				}
			}
		});
	}

	private void registerEvents() {
		shortRegEvents(new Cooldown());
		shortRegEvents(new Swear());
		shortRegEvents(new Ad());
		shortRegEvents(new Caps());
		shortRegEvents(new ChatBlocked());
		shortRegEvents(new Command());
	}

	private void shortRegEvents(Listener listener) {
		this.getServer().getPluginManager().registerEvents(listener, this);
	}

	public static ChatManager getInstance() {
		return plugin;
	}
}
