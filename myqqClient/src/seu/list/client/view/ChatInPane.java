package seu.list.client.view;

import java.awt.AWTEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import seu.list.widget.SToolbarButton;

public class ChatInPane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -737473298299215449L;
	private JTextField txtInput;
	private JButton btnSend;
	private JButton btnClose;
	private ICallback caller;
	private JButton btnFile;
	private JProgressBar pbFile;
	private SToolbarButton btnFont;
	private SToolbarButton btnFace;
	private SToolbarButton btnShake;
	private SToolbarButton btnActionFace;

	public ChatInPane() {
		try {
			initWidgets();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public ChatInPane(ICallback caller) {
		this();
		this.setCaller(caller);
	}

	private void initWidgets() throws IOException {
		GridLayout gl = new GridLayout(3, 1);
		this.setLayout(gl);
		//
		createToolbar();
		//
		createInputPane();
		//
		createCommandPane();
	}

	private void createInputPane() {
		txtInput = new JTextField(25);
		add(txtInput);
	}

	private void createCommandPane() {
		JPanel jpBtn = new JPanel();
		add(jpBtn);

		btnClose = new JButton("关闭");
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				doClose(evt);
			}
		});
		btnSend = new JButton("发送");
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				doSend(evt);
			}
		});

		jpBtn.add(btnClose);
		jpBtn.add(btnSend);
	}

	private void createToolbar() throws IOException {
		JPanel jpToolbar = new JPanel();
		jpToolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(jpToolbar);
		//

		String fn = ChatInPane.class.getResource("/image/chat-tb01.jpg").getFile();
		//System.out.println(URLDecoder.decode(fn, "utf-8"));
		fn = URLDecoder.decode(fn, "utf-8");
		BufferedImage bi = ImageIO.read(new File(fn));
		int height = bi.getHeight();
		int width = bi.getWidth();
		int x = 0;
		int y = 0;
		int w = width / 5;
		int h = height;
		// --Font
		ImageIcon icon = new ImageIcon(bi.getSubimage(x, y, w, h));
		btnFont = new SToolbarButton(icon);
		jpToolbar.add(btnFont);
		btnFont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				doFont(evt);
			}
		});
		x += w;
		// --Face
		icon = new ImageIcon(bi.getSubimage(x, y, w, h));
		btnFace = new SToolbarButton(icon);
		jpToolbar.add(btnFace);
		btnFace.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				doFace(evt);
			}
		});
		x += w;
		// --Action Face
		icon = new ImageIcon(bi.getSubimage(x, y, w, h));
		btnActionFace = new SToolbarButton(icon);
		jpToolbar.add(btnActionFace);
		btnActionFace.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				doActionFace(evt);
			}
		});
		x += w;
		// --Shake
		icon = new ImageIcon(bi.getSubimage(x, y, w, h));
		btnShake = new SToolbarButton(icon);
		jpToolbar.add(btnShake);
		btnShake.setToolTipText("震动一下");
		btnShake.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				doShake(evt);
			}
		});
		x += w;
		// --File
		icon = new ImageIcon(bi.getSubimage(x, y, w, h));
		btnFile = new SToolbarButton(icon);
		btnFile.setToolTipText("发送文件");
		jpToolbar.add(btnFile);
		btnFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				doFile(evt);
			}
		});
		//

		//
		pbFile = new JProgressBar();
		jpToolbar.add(pbFile);
		pbFile.setVisible(false);
	}
/**
 * 发送抖动命令
 * @param evt
 */
	protected void doShake(ActionEvent evt) {
		if (caller != null)
			this.caller.doCallback(this, new MyAWTEvent(evt, MyAWTEvent.SHAKE));
		else {
			System.out.println(ChatInPane.class + "doShake()");
		}		
	}

	protected void doActionFace(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	protected void doFace(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	protected void doFont(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	protected void doFile(AWTEvent evt) {
		if (caller != null)
			this.caller.doCallback(this, new MyAWTEvent(evt, MyAWTEvent.FILE));
		else {
			System.out.println(ChatInPane.class + "doFile()");
		}

	}

	protected void doClose(AWTEvent evt) {
		if (caller != null)
			this.caller.doCallback(this, new MyAWTEvent(evt, MyAWTEvent.CLOSE));
		else {
			System.out.println(ChatInPane.class + "doClose()");
		}
	}

	protected void doSend(AWTEvent evt) {
		if (caller != null)
			this.caller.doCallback(this, new MyAWTEvent(evt, MyAWTEvent.SEND));
		else {
			System.out.println(ChatInPane.class + "doSend():" + this.getText());
		}
	}

	public void setCaller(ICallback ic) {
		this.caller = ic;
	}

	public String getText() {
		return this.txtInput.getText();
	}

	public void setText(String string) {
		this.txtInput.setText(string);
	}

	public JButton getDefaultButton() {
		return this.btnSend;
	}

	public void showProgress(int percent) {		
		this.pbFile.setValue(percent);
		this.pbFile.setToolTipText(percent + "%");
	}

	public void showProgress(boolean b) {
		this.pbFile.setVisible(b);
		this.btnFile.setEnabled(!b);
	}

	//
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		ChatInPane chatInPane = new ChatInPane();
		jf.add(chatInPane);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(400, 400);
		jf.setVisible(true);
	}
}
