import java.net.SocketAddress;

public class UserInfo {
	private String icon;
	private String name;
	private int lost;
	private SocketAddress address;
	private ChatFrame chatFrame;
	
	public UserInfo(String icon, String name, SocketAddress address, int lost) {
		this.icon = icon;
		this.name = name;
		this.address = address;
		this.lost = lost;	
	}
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SocketAddress getAddress() {
		return address;
	}

	public void setAddress(SocketAddress address) {
		this.address = address;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;		
	}

	public ChatFrame getChatFrame() {
		return chatFrame;
	}

	public void setChatFrame(ChatFrame chatFrame) {
		this.chatFrame = chatFrame;
	}

	@Override
	public int hashCode() {
		return address.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj != null && obj.getClass() == UserInfo.class) {
			UserInfo target = (UserInfo)obj;
			if (address != null) {
				return address.equals(target.address);
			}
		}

		return false;
	}
	
}
