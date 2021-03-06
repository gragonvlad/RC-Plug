package relevant_craft.test.fixes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class RightClick implements Listener {

	// При нажатии у игрока
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerClick(PlayerInteractEvent e) throws EventException
	{ 
	  if ((e.getItem() != null) && (e.getPlayer() != null))
	  {
		  Player p = e.getPlayer();
		  int i = e.getItem().getTypeId();
		  
		  // ExtraCells: МЭ Контейнер (4396:4)
          if ((i == 4396) && (p.isSneaking()))
          {
        	e.setCancelled(true);
        	p.sendMessage("§a[§6RC-Fix§a]§c Я думаю, что тебе не нужны другие режимы...");     
          	
          }
          
		  // IC2: Латекс
		  if (i == 30217)
		  {
		    e.setCancelled(true);
		    p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено ставить!");
		  }
		  
		  // Applite Energystic: Материальная пушка
		  if (i == 4372)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  
		  // Applite Energystic: Катализатор энтропии
		  if (i == 4363)
		  {
			e.setCancelled(true);
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  
		  // Applite Energystic: Катализатор вибрации
		  if (i == 4364)
		  {
			e.setCancelled(true);
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }

		  // Custum NPC: Верстак плотника
		  if (i == 1526)
		  {
			e.setCancelled(true);
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено ставить!"); 
		  }

		  // Forestry: письмо
		  if (i == 13373)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  // Forestry: рюкзаки
		  if (i == 13304)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  if (i == 13305)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  if (i == 13306)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  if (i == 13307)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  if (i == 13343)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  if (i == 13344)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  if (i == 13345)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  if (i == 13346)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  if (i == 13347)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  if (i == 13352)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  if (i == 13353)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  if (i == 13362)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  if (i == 13363)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  
		  // ProjectRed: сумки
		  if (i == 9284)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  
		  // IC2: анализатор агрокультур
		  if (i == 30122)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
		  
		  // IC2: ящик для инструментов
		  if (i == 30117)
		  {
			e.setCancelled(true);
			p.getInventory().removeItem(p.getInventory().getItemInHand());
			p.sendMessage("§a[§6RC-Fix§a]§c Данный предмет запрещено использовать!"); 
		  }
	  }
	}
}
