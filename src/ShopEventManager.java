import java.util.ArrayList;
import java.util.List;

import esercizio.product.Product;

//Observed
public final class ShopEventManager {
	//Singleton
	private static ShopEventManager instance;
	
	public static ShopEventManager getInstance() {
		if (instance == null)
			instance = new ShopEventManager();
		return instance;
	}
	
	List<Client> clients = new ArrayList<Client>();
	
	public void subscribe(Client client) {
		if (!clients.contains(client))
			clients.add(client);
	}
	
	public void unsubscribe(Client client) {
		if (clients.contains(client))
			clients.remove(client);
	}
	
	public void notifySubscribers(Product product) {
		clients.forEach(c -> c.update("Nuovo prodotto disponibile: " + product.getProductName() + "\nPrezzo: " + product.getCost()));
	}
	
}

