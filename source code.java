package drnose21.plugin;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
public class drkitpvp extends JavaPlugin implements Listener {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static drkitpvp plugin;
	public ArrayList<Player> cooldown = new ArrayList<Player>();
	public ArrayList<Player> weakness = new ArrayList<Player>();
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
	}
	private void openGUI(Player player){
		ItemStack assasingui = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta assasinguimeta = assasingui.getItemMeta();
		assasinguimeta.setDisplayName(ChatColor.GOLD+"Assasin");
		assasingui.setItemMeta(assasinguimeta);
		ItemStack bow = new ItemStack(Material.BOW, 1);
		ItemMeta bowm = bow.getItemMeta();
		bowm.setDisplayName(ChatColor.GOLD+"Archer");
		bow.setItemMeta(bowm);
		ItemStack heavy = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta heavymeta = heavy.getItemMeta();
		heavymeta.setDisplayName(ChatColor.GOLD+"Heavy");
		heavy.setItemMeta(heavymeta);
		ItemStack pyro= new ItemStack(Material.FIRE);
		ItemMeta pyrometa = pyro.getItemMeta();
		pyrometa.setDisplayName(ChatColor.GOLD+"Pyro");
		pyro.setItemMeta(pyrometa);
		ItemStack pvp= new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta pvpmeta = pvp.getItemMeta();
		pvpmeta.setDisplayName(ChatColor.GOLD+"Pvp");
		pvp.setItemMeta(pvpmeta);
	Inventory kits = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN +"Kit selector");
	kits.setItem(0,pvp);
	kits.setItem(1,assasingui);
	kits.setItem(2, bow);
	kits.setItem(3, heavy);
	kits.setItem(4, pyro);
	player.openInventory(kits);
	}

	@EventHandler
	public void OnInventoryClick(InventoryClickEvent event){
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Kit selector"))
				return;
		
		Player player =(Player) event.getWhoClicked();
		event.setCancelled(true);
		player.closeInventory();
		
		
		
	switch(event.getCurrentItem().getType()){
	case NETHER_STAR:
		ItemStack stew = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta stewmeta=stew.getItemMeta();
		stewmeta.setDisplayName(ChatColor.RED+"Insta-soup");
		stew.setItemMeta(stewmeta);
		ItemStack NinjaStar = new ItemStack(Material.NETHER_STAR);
        ItemMeta NinjaStarmeta = NinjaStar.getItemMeta();
        NinjaStarmeta.setDisplayName(ChatColor.GOLD + "Ninja Star");
        ArrayList<String> NinjaStarlore = new ArrayList<String>();
        NinjaStarlore.add(ChatColor.RED + "Right click to activate assassination mode");
        NinjaStarmeta.setLore(NinjaStarlore);
        NinjaStar.setItemMeta(NinjaStarmeta);
        ItemStack AssassinHat = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta AHat = (LeatherArmorMeta)AssassinHat.getItemMeta();
        AHat.setColor(Color.WHITE);
        AssassinHat.setItemMeta(AHat);
        AssassinHat.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        ItemStack AssassinChest = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta AChest = AssassinChest.getItemMeta();
        AssassinChest.setItemMeta(AChest);
        ItemStack AssassinLegs = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta ALegs = AssassinLegs.getItemMeta();
        AssassinLegs.setItemMeta(ALegs);
        ItemStack AssassinBoots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta ABoots = (LeatherArmorMeta)AssassinBoots.getItemMeta();
        ABoots.setColor(Color.WHITE);
        AssassinBoots.setItemMeta(ABoots);
        AssassinBoots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        AssassinBoots.addEnchantment(Enchantment.PROTECTION_FALL, 2);
        ItemStack SSword = new ItemStack(Material.STONE_SWORD);
        SSword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        SSword.addEnchantment(Enchantment.DURABILITY, 3);
        player.sendMessage(ChatColor.GOLD + "You have been given the Assassin kit!");
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 2.0F, 2.0F);
        player.getInventory().clear();
        player.getInventory().setHelmet(AssassinHat);
        player.getInventory().setBoots(AssassinBoots);
        player.getInventory().setChestplate(AssassinChest);
        player.getInventory().setLeggings(AssassinLegs);
        player.getInventory().addItem(new ItemStack[] { SSword });
        player.getInventory().addItem(new ItemStack[] { NinjaStar });
        player.setSaturation(100);  
        for (int i = 0; i < 34; i++)
            player.getInventory().addItem(stew);
      	player.closeInventory();
      	event.setCancelled(true);
      	break;
	case BOW:
		ItemStack stew1 = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta stewmeta1=stew1.getItemMeta();
		stewmeta1.setDisplayName(ChatColor.RED+"Insta-soup");
		stew1.setItemMeta(stewmeta1);
		ItemStack ABow = new ItemStack(Material.BOW);
        ABow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 2);
        player.sendMessage(ChatColor.GOLD + "You have been given the Archer kit!");
        player.getInventory().clear();
        player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
        player.getInventory().addItem(new ItemStack[] { ABow });
        player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
          player.setSaturation(100);
        for (int i = 0; i < 33; i++)
        player.getInventory().addItem(stew1);
        player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW) });
        player.closeInventory();
      	event.setCancelled(true);
      	break;
	case DIAMOND_CHESTPLATE:
		ItemStack stew2 = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta stewmeta2=stew2.getItemMeta();
		stewmeta2.setDisplayName(ChatColor.RED+"Insta-soup");
		stew2.setItemMeta(stewmeta2);
		player.sendMessage(ChatColor.GOLD + "You have been given the Heavy kit!");
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2147483647, 1));
        player.getInventory().clear();
        player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.IRON_SWORD) });
        player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        player.setSaturation(100);
        for (int i = 0; i < 35; i++)
            player.getInventory().addItem(stew2);
        player.closeInventory();
      	event.setCancelled(true);
      	break;
	case FIRE:
		ItemStack stew3 = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta stewmeta3=stew3.getItemMeta();
		stewmeta3.setDisplayName(ChatColor.RED+"Insta-soup");
		stew3.setItemMeta(stewmeta3);
		ItemStack Arrow = new ItemStack(Material.ARROW, 64);
        ItemStack SSword2 = new ItemStack(Material.STONE_SWORD);
        SSword2.addEnchantment(Enchantment.FIRE_ASPECT, 1);
        ItemStack FBow = new ItemStack(Material.BOW);
        FBow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 2);
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2147483647, 1));
        player.sendMessage(ChatColor.GOLD + "You have been given the Pyro kit!");
        player.getInventory().clear();
        player.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
        player.getInventory().addItem(new ItemStack[] { SSword2 });
        player.getInventory().addItem(new ItemStack[] { FBow });
        player.getInventory().addItem(new ItemStack[] { Arrow });
        player.setSaturation(100);
        for (int i = 0; i < 33; i++)
            player.getInventory().addItem(stew3);
        player.closeInventory();
      	event.setCancelled(true);
      	break;
	case DIAMOND_SWORD:
		ItemStack stew4 = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta stewmeta4=stew4.getItemMeta();
		stewmeta4.setDisplayName(ChatColor.RED+"Insta-soup");
		stew4.setItemMeta(stewmeta4);
		 player.sendMessage(ChatColor.GOLD + "You have been given the Pvp kit!");
		 player.getInventory().clear();
         player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.DIAMOND_SWORD) });
         player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
         player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
         player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
         player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
         player.setSaturation(100);
         for (int i = 0; i < 35; i++)
             player.getInventory().addItem(stew4);
         player.closeInventory();
       	event.setCancelled(true);
       	break;
	default:
		player.closeInventory();
		event.setCancelled(true);
		break;
}
	}
	 @EventHandler
		public void OnPlayerInteract2(PlayerInteractEvent event){
			Action a = event.getAction();
			ItemStack is = event.getItem();
			Player player = event.getPlayer();
			if(a == Action.PHYSICAL || is == null || is.getType()==Material.AIR){
				return;
			}
			if(player.getItemInHand().getType().equals(Material.MUSHROOM_SOUP)&&player.getHealth()<=14){
				double health=6;
				player.setHealth(player.getHealth()+health);
				if(player.getItemInHand().getType().equals(Material.MUSHROOM_SOUP))
						player.getItemInHand().setType(Material.BOWL);
			}
			else if(player.getItemInHand().getType().equals(Material.MUSHROOM_SOUP)&&player.getFoodLevel()<=14){
				int food=6;
				player.setFoodLevel(player.getFoodLevel()+food);
				if(player.getItemInHand().getType().equals(Material.MUSHROOM_SOUP))
					player.getItemInHand().setType(Material.BOWL);
			}
			else if(player.getItemInHand().getType().equals(Material.MUSHROOM_SOUP)&&player.getHealth()>14&&player.getHealth()!=20){
				double health=20-player.getHealth();
				
				player.setHealth(player.getHealth()+health);
				
				if(player.getItemInHand().getType().equals(Material.MUSHROOM_SOUP))
					player.getItemInHand().setType(Material.BOWL);
			}
			else if(player.getItemInHand().getType().equals(Material.MUSHROOM_SOUP)&&player.getFoodLevel()>14&&player.getFoodLevel()!=20){
				int food =20-player.getFoodLevel();
				player.setFoodLevel(player.getFoodLevel()+food);
				if(player.getItemInHand().getType().equals(Material.MUSHROOM_SOUP))
					player.getItemInHand().setType(Material.BOWL);
			}
	 }
	 @EventHandler
		public void OnPlayerInteract(PlayerInteractEvent event){
			Action a = event.getAction();
			ItemStack is = event.getItem();
			
			if(a == Action.PHYSICAL || is == null || is.getType()==Material.AIR){
				return;
			}
			if(is.getType()==Material.COMPASS){
				openGUI(event.getPlayer());
			}
	 }
	 @EventHandler
		public void OnPlayerJoin(PlayerJoinEvent event){
			ItemStack compass= new ItemStack(Material.COMPASS, 1);
			ItemMeta metass=compass.getItemMeta();
			metass.setDisplayName(ChatColor.DARK_PURPLE+"Kit Selector");
			compass.setItemMeta(metass);
			compass.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
			event.getPlayer().getInventory().addItem(compass);
		}
	 @EventHandler
		public void OnPlayerQuit(PlayerQuitEvent event){
		 	ItemStack is = new ItemStack(Material.AIR);
			PlayerInventory pa = event.getPlayer().getInventory();
			pa.clear();
			pa.setHelmet(is);
		    pa.setChestplate(is);
		    pa.setLeggings(is);
		    pa.setBoots(is);
		    
		}
		@EventHandler
		public void OnPlayerRespawn(PlayerRespawnEvent event){
			ItemStack is = new ItemStack(Material.AIR);
			PlayerInventory pa = event.getPlayer().getInventory();
			pa.clear();
			pa.setHelmet(is);
		    pa.setChestplate(is);
		    pa.setLeggings(is);
		    pa.setBoots(is);
			ItemStack compass= new ItemStack(Material.COMPASS, 1);
			ItemMeta metass=compass.getItemMeta();
			metass.setDisplayName(ChatColor.DARK_PURPLE+"Kit Selector");
			compass.setItemMeta(metass);
			compass.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
			event.getPlayer().getInventory().addItem(compass);
			
		}
		@EventHandler
		public void onEntityDeath(EntityDeathEvent e)
	    {
	        e.getDrops().clear();
	        }
		@EventHandler
	    public void onItemSpawn(ItemSpawnEvent event) {
	                event.getEntity().remove();
	               
	              
	    }
		@EventHandler
			public void OnPlayerInteract1(PlayerInteractEvent event){
				Action a = event.getAction();
				ItemStack is = event.getItem();
				final Player player1 = event.getPlayer();
				 
				
				if(a == Action.PHYSICAL || is == null || is.getType()==Material.AIR){
					return;
				}
				if(is.getType()==Material.NETHER_STAR&&cooldown.contains(player1)==true){
					player1.sendMessage(ChatColor.RED + 
			                  "You may use this ability again soon");
				}
				else if(player1.getItemInHand().getType().equals(Material.NETHER_STAR)&&cooldown.contains(player1)==false){
					cooldown.add(player1);
					weakness.add(player1);
		    		 player1.sendMessage(ChatColor.DARK_PURPLE + "Time to assassinate!");
		             player1.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 300, 0));
		             player1.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 0));
		             Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable()
			 			{
			 				public void run() {
			 					weakness.add(player1);
			 					player1.sendMessage(ChatColor.DARK_PURPLE + "You feel your powers weaken!");
			 					player1.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,300,0));
								}
			 				
			 			},310);
		             Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable()
		 			{
		 				public void run() {
		 					cooldown.remove(player1);
		 					player1.sendMessage(ChatColor.DARK_PURPLE + "You can assassinate again!");
							}
		 				
		 			},1800);
		             
				}
		 }
		 @EventHandler
		  public void onRightClick(PlayerInteractEvent e) {
			 ItemStack stew5 = new ItemStack(Material.MUSHROOM_SOUP);
				ItemMeta stewmeta5=stew5.getItemMeta();
				stewmeta5.setDisplayName(ChatColor.RED+"Insta-soup");
				stew5.setItemMeta(stewmeta5);
			 Player p = e.getPlayer();
		    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
		      (e.getClickedBlock().getType() == Material.CHEST)) {
		      Chest c = (Chest)e.getClickedBlock().getState();
		        e.setCancelled(true);
		        int size = c.getInventory().getSize();
		        if (size > 54)
		          size = 54;
		        Inventory i = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', ChatColor.LIGHT_PURPLE +"Soup Chest"));
		        for (int x = 0; x < i.getSize(); x++) {
		          i.setItem(x, new ItemStack(Material.MUSHROOM_SOUP));
		          i.setItem(x, stew5);
		        }
		   
		        p.openInventory(i);
		      }
		    
		
	
}
}

	  

