package relevant_craft.test.fixes.other;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

import relevant_craft.test.Main;

public class TinkerFix implements Listener {
	List<Location> blocks = new ArrayList<Location>();
	
	//Фикс дюпа со столом "Конструкор Деталей"
	@EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Block b = e.getBlock();
        Player p = e.getPlayer();
 
        if ((b.getTypeId() == 1471 && b.getData() == 1) || (b.getTypeId() == 3243 && b.getData() == 2)) {
	        if (blocks.contains(b.getLocation())) {
	        	p.sendMessage("§a[§6RC-Fix§a]§c Нельзя ломать данный блок сильно часто!");
	        	e.setCancelled(true);
	        }
        }
	}
 
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        final Block b = e.getBlock();
        blocks.add(b.getLocation());
 
        if ((b.getTypeId() == 1471 && b.getData() == 1) || (b.getTypeId() == 3243 && b.getData() == 2)) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
 
	            @Override
	            public void run() {
	                blocks.remove(b.getLocation());
	            }
	        }, 10 * 60 * 20);
        }
 
    }
	
	//Фикс установки "Конструкор Деталей"
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlaceCunstructor(BlockPlaceEvent e) {

		Block b = e.getBlock();
		BlockFace[] faces = { BlockFace.DOWN, BlockFace.UP, BlockFace.EAST, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.WEST };

	for (BlockFace bf : faces)
		if ((isConstr(b) && b.getRelative(bf).getTypeId() == 1471) || (isConstr(b.getRelative(bf)) && b.getTypeId() == 1471))
				{
				e.getPlayer().sendMessage("§a[§6RC-Fix§a]§c Эти блоки нельзя ставить рядом!");
				e.setCancelled(true);
				}
	}
 
    private boolean isConstr(Block b) {
        if (b == null)
            return true;
 
        int[] constrs = { 3243 };
        for (int contr : constrs)
            if (b.getTypeId() == contr)
                return true;
        return false;
    }
    
	//Фикс дюпа Верстак инженера
    @EventHandler
    public void onIngenner(InventoryClickEvent e)
    {
    	if((e.getInventory() != null && e.getCurrentItem() != null && e.getView().getPlayer() != null) && ((e.getInventory().getTitle().equalsIgnoreCase("crafters.CraftingStation"))))
	    {
	    	if(e.getClick() == ClickType.NUMBER_KEY)
	    	{
	    		e.setCancelled(true); 
	    		Bukkit.getServer().getPlayer(e.getView().getPlayer().getName()).sendMessage("§a[§6RC-Fix§a]§c Не надо так...");
	    	}
	    	else
	    	{
	    		return;
	    	}
	    }
	    else
	    {
	    	return;
	    }
    }
    
	//Фикс дюпа Плавильня
    @EventHandler
    public void onPlav(InventoryClickEvent e)
    {
    	if((e.getInventory() != null && e.getCurrentItem() != null && e.getView().getPlayer() != null) && ((e.getInventory().getTitle().equalsIgnoreCase("crafters.Smeltery"))))
	    {
	    	if(e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT)
	    	{
	    		e.setCancelled(true); 
	    		Bukkit.getServer().getPlayer(e.getView().getPlayer().getName()).sendMessage("§a[§6RC-Fix§a]§c Shift запрещен!");
	    	}
	    	else
	    	{
	    		return;
	    	}
	    }
	    else
	    {
	    	return;
	    }
    }
    
	//Запрещаем модифицировать Рапиру
    @EventHandler (priority = EventPriority.HIGHEST)
	public void onRapiraf(InventoryClickEvent e)
	{
		if ((e.getInventory() != null) && (e.getCurrentItem() != null) && (e.getInventory().getTitle().equalsIgnoreCase("crafters.ToolForge")))
	    {
	      int i = e.getCurrentItem().getTypeId();
	      if (i == 14313)
	      {
	    	  Bukkit.getServer().getPlayer(e.getView().getPlayer().getName()).sendMessage("§a[§6RC-Fix§a]§c Запрещено модифицировать данный предмет!");
	    	  e.setCancelled(true);
	      }
	    }
	}
    
    //Запрещаем ударять рапирой по игроку
    @EventHandler (priority = EventPriority.HIGHEST)
	public void onRapira(EntityDamageByEntityEvent e)
	{
    	
	}
    
	// Фикс установки блоков
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onTNTPlace(BlockPlaceEvent e)
	{
	    Player p = e.getPlayer();
	    Block b = e.getBlock();
	    int id = b.getTypeId();
	    int data = b.getData();
	    if (p != null)
	    {
	    	if ((id == 3247) || (id == 1470))
	        {
	          e.setCancelled(true);
	          p.sendMessage("§a[§6RC-Fix§a]§c Данный блок запрещено ставить!");
	        }
	    }
	}
    
	//Фикс установки Стойки и Кузни
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlaceCusna(BlockPlaceEvent e) {

		Block b = e.getBlock();
		BlockFace[] faces = { BlockFace.DOWN, BlockFace.UP, BlockFace.EAST, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.WEST };

	for (BlockFace bf : faces)
		if ((isCusna(b) && b.getRelative(bf).getTypeId() == 2249) || (isCusna(b.getRelative(bf)) && b.getTypeId() == 2249))
				{
				e.getPlayer().sendMessage("§a[§6RC-Fix§a]§c Эти блоки нельзя ставить рядом!");
				e.setCancelled(true);
				}
	}
 
    private boolean isCusna(Block b) {
        if (b == null)
            return true;
 
        int[] cusni = { 1468, 3243 };
        for (int cusna : cusni)
            if (b.getTypeId() == cusna)
                return true;
        return false;
    }
	
}
