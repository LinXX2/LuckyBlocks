package linxx.luckyblocks.main;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import linxx.luckyblocks.api.API;
import linxx.luckyblocks.api.LuckyEvent;
import linxx.luckyblocks.api.ModuleLoader;
import linxx.luckyblocks.commands.GetOpenedLuckyBlocks;
import linxx.luckyblocks.commands.GiveLuckyBlock;
import linxx.luckyblocks.commands.SetLuckyRecipe;
import linxx.luckyblocks.listener.InventoryClick;
import linxx.luckyblocks.listener.InventoryCloseListener;
import linxx.luckyblocks.listener.LuckyBlockBreake;
import linxx.luckyblocks.listener.LuckyBlockPlace;
import linxx.luckyblocks.misc.LuckyEvents;
import linxx.luckyblocks.misc.Methods;


public class LuckyBlocks extends JavaPlugin {

	private static LuckyBlocks instance;
	public File craftingRecipeFile;
	public File messageFile;
	public File playersFile;
	public File settingsFile;
	public Logger log;
	public Methods methods;
	public API api;
	public LuckyEvents luckyEvents;
	public YamlConfiguration craftingcfg;
	public YamlConfiguration messagecfg;
	public YamlConfiguration playerscfg;
	public YamlConfiguration settingscfg;
	public List< Location > locs = new ArrayList< Location >();
	public List< LuckyEvent > luckyevents = new ArrayList<>();
	public List< LuckyEvent > unluckyevents = new ArrayList<>();
	public List< Integer > achivementsteps = new ArrayList< Integer >();
	public ClassLoader cl;

	@Override
	public void onEnable() {
		this.cl = this.getClassLoader();
		try {
			oninit();
		} catch ( IOException | InvalidConfigurationException e ) {
			e.printStackTrace();
		}
		this.instance = this;
		ModuleLoader.load();
	}

	private void oninit() throws IOException, InvalidConfigurationException {

		manageFile();
		methods = new Methods( this );
		api = new API( this );
		luckyEvents = new LuckyEvents( this );
		log = this.getLogger();
		methods.addRecipes();
		registerCommands();
		registerEvents();
		luckyEvents.addEvents();
		setAchivementSteps();

	}

	@Override
	public void onDisable() {

		log.info( " Version: " + getDescription().getVersion() + " was Disables!" );
	}

	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents( new LuckyBlockPlace( this ), this );
		pm.registerEvents( new LuckyBlockBreake( this ), this );
		pm.registerEvents( new InventoryClick( this ), this );
		pm.registerEvents( new InventoryCloseListener( this ), this );
	}

	private void registerCommands() {

		getCommand( "giveluckyblock" ).setExecutor( new GiveLuckyBlock( this ) );
		getCommand( "setLuckyRecipe" ).setExecutor( new SetLuckyRecipe( this ) );
		getCommand( "getopenedluckyblocks" ).setExecutor( new GetOpenedLuckyBlocks( this ) );
	}

	private void manageFile() throws FileNotFoundException, IOException, InvalidConfigurationException {
		System.setProperty( "file.encoding", "UTF-8" );
		craftingRecipeFile = new File( getDataFolder().getPath(), "Recipe.yml" );
		if ( !craftingRecipeFile.exists() ) {
			saveResource( "Recipe.yml", true );
		}
		craftingcfg = new YamlConfiguration();
		craftingcfg.load( craftingRecipeFile );

		messageFile = new File( getDataFolder().getPath(), "Messages.yml" );
		if ( !messageFile.exists() ) {
			saveResource( "Messages.yml", true );
		}
		messagecfg = new YamlConfiguration();
		messagecfg.load( messageFile );

		playersFile = new File( getDataFolder().getPath(), "players.yml" );
		if ( !playersFile.exists() ) {
			saveResource( "players.yml", true );
		}
		playerscfg = new YamlConfiguration();
		playerscfg.load( playersFile );

		settingsFile = new File( getDataFolder().getPath(), "settings.yml" );
		if ( !settingsFile.exists() ) {
			saveResource( "settings.yml", true );
		}
		settingscfg = new YamlConfiguration();
		settingscfg.load( settingsFile );

	}

	private void setAchivementSteps() {
		this.achivementsteps.add( 5 );
		this.achivementsteps.add( 15 );
		this.achivementsteps.add( 30 );
		this.achivementsteps.add( 45 );
		this.achivementsteps.add( 70 );
		this.achivementsteps.add( 100 );
		this.achivementsteps.add( 150 );
		this.achivementsteps.add( 200 );
		this.achivementsteps.add( 300 );
		this.achivementsteps.add( 400 );
		this.achivementsteps.add( 500 );
		this.achivementsteps.add( 600 );
		this.achivementsteps.add( 700 );

	}

	public static LuckyBlocks GET_INSTANCE() {
		return instance;
	}
}
