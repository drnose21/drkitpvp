public class KitCreator{
public KitCreator(String name, ChatColor color, Material weapon1, Material h, Material c, Material l, Player p){
Player player = p;

ItemStack hat=new ItemStack(h);
ItemStack chest=new ItemStack(c);
ItemStack legs= new ItemStack(l);
ItemStack boots=new ItemStack(b)
ItemStack weapon=new ItemStack(weapon1);

ArmorMeta hatmeta=hat.getItemMeta();
ArmorMeta chestmeta=chest.getItemMeta();
ArmorMeta legsmeta=legs.getItemMeta();
ArmorMeta bootsmeta=boots.getItemMeta();
ItemMeta weaponmeta=weapon.getItemMeta();

hatmeta.setDisplayName(color +" " + name + " helmet");
chestmeta.setDisplayName(color+" "  name + " chestplate");
legsmeta.setDisplayName(color+" "  name + " leggings");
bootsmeta.setDisplayName(color+" "  name + " boots");
weaponmeta.setDisplayName(color+" "  name + " sword")

hat.setItemMeta(hetmeta);
chest.setItemMeta(chestmeta);
legs.setItemMeta(legsmeta);
boots.setItemMeta(bootsmeta);
weapon.setItemMeta(weaponmeta);

p.sendMessage(ChatColor.Gold + "You have been given the "+ name+ " kit!");

p.getInventory().clear();
p.getInventory().setHelmet(hat);
p.getInventory().setChestplate(chest);
p.getInventory().setLeggings(legs);
p.getInventory().setBoots(boots);
p.getInventory().addItem(weapon);
p.setSaturation(100);

}
}
