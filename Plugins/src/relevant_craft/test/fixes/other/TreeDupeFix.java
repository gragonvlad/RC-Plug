package relevant_craft.test.fixes.other;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

@SuppressWarnings("deprecation")
public class TreeDupeFix implements Listener {

	  @EventHandler(priority = EventPriority.HIGHEST)
	  public void onPlayerInteract(PlayerInteractEvent e) {
		
	    if ((e.getClickedBlock() != null) && (e.getPlayer() != null))
	    {
	    	
	    Block b = e.getClickedBlock();
		BlockFace[] faces = { BlockFace.EAST, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.WEST };

		for (BlockFace bf : faces)
		if ((isTree(b)) && (!b.getRelative(bf).getType().equals(Material.AIR)) && (e.getPlayer().getItemInHand().getType().equals(Material.INK_SACK)) && (e.getAction() == Action.RIGHT_CLICK_BLOCK))
				{
					e.getPlayer().sendMessage("§a[§6RC-Fix§a]§c Я думаю блок, который стоит рядом - мешает...");
					e.setCancelled(true);
				}
	    }
	  }
	  
	  public boolean isTree(Block block) {
		  	//Гевея
		    if(block.getTypeId() == 4007)
		    	return true;
		    //Обычный саженец
		    if(block.getTypeId() == 6)
		    	return true;
		    //Слизистый саженец
		    if(block.getTypeId() == 3241)
		    	return true;
		    //Саженец из ProjectRed
		    if(block.getTypeId() == 2137)
		    	return true;
		    
		    return false;
	  }
}
