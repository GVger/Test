// ListDlg.cpp : implementation file
//

#include "stdafx.h"
#include "List.h"
#include "ListDlg.h"

#include <mmsystem.h>
#pragma comment(lib,"WINMM.LIB")

#include "ModiBox.h"
#include "AddBox.h"
#include "SearchBox.h"
#include "About.h"

#define ITEMCOUNT 100

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CListDlg dialog

CListDlg::CListDlg(CWnd* pParent /*=NULL*/)
	: CDialog(CListDlg::IDD, pParent)
{
	//{{AFX_DATA_INIT(CListDlg)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
	// Note that LoadIcon does not require a subsequent DestroyIcon in Win32
	m_hIcon = AfxGetApp()->LoadIcon(IDI_ICON1);
	isLager=true;
	rectAfter.left=0;
	rectAfter.top=0;
	rectAfter.right=0;
	rectAfter.bottom=0;
	rectBefore.left=0;
	rectBefore.top=0;
	rectBefore.right=0;
	rectBefore.bottom=0;
	m_saveComb=m_showComb=m_strName=m_strPhone="";
}

void CListDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CListDlg)
	DDX_Control(pDX, IDC_CONTENT, m_Content);
	//}}AFX_DATA_MAP
}

BEGIN_MESSAGE_MAP(CListDlg, CDialog)
	//{{AFX_MSG_MAP(CListDlg)
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	ON_WM_TIMER()
	ON_BN_CLICKED(IDC_OPEN, OnOpen)
	ON_BN_CLICKED(IDC_SAVE, OnSave)
	ON_LBN_DBLCLK(IDC_CONTENT, OnDblclkContent)
	ON_BN_CLICKED(IDC_ADD, OnAdd)
	ON_BN_CLICKED(IDC_CHANGE, OnChange)
	ON_BN_CLICKED(IDC_EXIT, OnExit)
	ON_BN_CLICKED(IDC_SEARCH, OnSearch)
	ON_BN_CLICKED(IDC_ABOUT, OnAbout)
	ON_WM_CTLCOLOR()
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//��ʼ���������

extern CListApp theApp;
BOOL CListDlg::OnInitDialog()
{
	CDialog::OnInitDialog();

	// Set the icon for this dialog.  The framework does this automatically
	//  when the application's main window is not a dialog
	SetIcon(m_hIcon, TRUE);			// Set big icon
	SetIcon(m_hIcon, FALSE);		// Set small icon
	
	// TODO: Add extra initialization here
//���ñ���	
	CBitmap bitmap;
	bitmap.LoadBitmap(IDB_BGROUND);
	m_BK.CreatePatternBrush(&bitmap);
	bitmap.DeleteObject();
//
	
	PlaySound("BK.wav",NULL,SND_ASYNC | SND_LOOP | SND_FILENAME);

	m_icons[0]=LoadIcon(theApp.m_hInstance,MAKEINTRESOURCE(IDI_ICON1));
	m_icons[1]=LoadIcon(theApp.m_hInstance,MAKEINTRESOURCE(IDI_ICON2));
	m_icons[2]=LoadIcon(theApp.m_hInstance,MAKEINTRESOURCE(IDI_ICON3));

	SetIcon(m_icons[0],FALSE);
	SetIcon(m_icons[0],TRUE);
	if(rectAfter.IsRectNull())
	{
		CRect rectSeparator;
		GetWindowRect(&rectBefore);
		GetDlgItem(IDC_SEPARATOR)->GetWindowRect(&rectSeparator);

		rectAfter.right=rectBefore.right;
		rectAfter.top=rectBefore.top;
		rectAfter.left=rectSeparator.left;
		rectAfter.bottom=rectSeparator.bottom;
	}
	if(isLager)
	{
		SetWindowPos(NULL,0,0,rectAfter.Width(),rectAfter.Height(),
			SWP_NOMOVE | SWP_NOZORDER); 
		isLager=false;
	}

	SetTimer(1,1000,NULL);
	return TRUE;  // return TRUE  unless you set the focus to a control
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//���ñ�������Ӧ
HBRUSH CListDlg::OnCtlColor(CDC* pDC, CWnd* pWnd, UINT nCtlColor) 
{
	HBRUSH hbr = CDialog::OnCtlColor(pDC, pWnd, nCtlColor);
	
	// TODO: Change any attributes of the DC here

	if(pWnd==this)
	{
		return m_BK;
	}

	// TODO: Return a different brush if the default is not desired
	return hbr;
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void CListDlg::OnPaint() 
{
	if (IsIconic())
	{
		CPaintDC dc(this); // device context for painting

		SendMessage(WM_ICONERASEBKGND, (WPARAM) dc.GetSafeHdc(), 0);

		// Center icon in client rectangle
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// Draw the icon
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialog::OnPaint();
	}
}

// The system calls this to obtain the cursor to display while the user drags
//  the minimized window.
HCURSOR CListDlg::OnQueryDragIcon()
{
	return (HCURSOR) m_hIcon;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//ͼ��任�������

void CListDlg::OnTimer(UINT nIDEvent) 
{
	// TODO: Add your message handler code here and/or call default
	static int i=1;
	SetIcon(m_icons[i],FALSE);
	i=++i%3;		//��i��0��2ѭ������
	CDialog::OnTimer(nIDEvent);
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//˫���޸Ĺ������

void CListDlg::OnDblclkContent() 
{
	// TODO: Add your control notification handler code here
	CModiBox ModiBox;
	if(1==ModiBox.DoModal())
	{
		int index=m_Content.GetCurSel();				//CListBoxѡ�������
		m_Content.DeleteString(index);					//ɾ����������
		m_Content.InsertString(index,ModiBox.GetShowComb());			//�����޸ĵ����ݵ�����λ��
	}
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//����ĺ����ǶԴ棬��ʾ���ַ����ӹ�

CString CListDlg::GetshowComb()
{
	return m_showComb;
}

CString CListDlg::GetSaveComb()
{
	return m_saveComb;
}

void CListDlg::SetName(CString str)
{
	m_strName=str;
}

void CListDlg::SetPhone(CString str)
{
	m_strPhone=str;
}

CString CListDlg::GetName()
{
	return m_strName;
}

CString CListDlg::GetPhone()
{
	return m_strPhone;
}

CString CListDlg::FindName(CString str)
{
	return str.Left(str.Find("$"));
}

CString CListDlg::FindPhone(CString str)
{
	return str.Mid(str.Find("$")+1,str.Find("~")-str.Find("$")-1);
}


void CListDlg::SetShowComb(CString Name, CString Phone)
{
	m_showComb=Name+"       "+Phone;
}

void CListDlg::SetSaveComb(CString Name, CString Phone)
{
	m_saveComb=Name+"$"+Phone+"~";
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//���빦�����

void CListDlg::OnOpen() 
{
	// TODO: Add your control notification handler code here
	m_Content.SetCurSel(-1);
	OpenVg();
}	


void CListDlg::OpenVg()
{
	CFileDialog fileOpen(TRUE);
	fileOpen.m_ofn.lpstrTitle="����ͨѶ¼";
	fileOpen.m_ofn.lpstrFilter="����ͨѶ¼�ļ�(*.vg)\0*.vg\0\0";
	if(IDOK==fileOpen.DoModal())
	{
		CString strTemp;
		CFile fileIn(fileOpen.GetFileName(),CFile::modeRead);
		fileIn.Read(strTemp.GetBuffer(fileIn.GetLength()),fileIn.GetLength());
		strTemp.ReleaseBuffer();									//��ʹ����GetBuffer�ı���CString��Ҫ��CString����Ҫ��ʹ��ReleaseBuffer
		int strLong=strTemp.GetLength();							//Ϊ�˲���ѭ�������ı�
		for(int i=0;i<strLong;)
		{
			SetShowComb(FindName(strTemp),FindPhone(strTemp));
			m_Open.Add(m_showComb.GetBuffer(m_showComb.GetLength()));
			m_showComb.ReleaseBuffer();
			int index=strTemp.Find("~")+1;
			strTemp.Delete(0,index);
			i+=index;
		}

		fileIn.Close();
		
		for(int j=0;j<m_Open.GetSize();j++)
		{
			m_Content.AddString(m_Open.GetAt(j));					//��ȡ���ݣ�������հ���
		}
		m_Open.RemoveAll();							//��֤���ٴε��벻�ᵼ��2����ͬ������
		if(!isLager)						//���û�еĹ�����������������ʾ����
		{
			SetWindowPos(NULL,0,0,rectBefore.Width(),rectBefore.Height(),SWP_NOMOVE | SWP_NOZORDER);
			CWnd::CenterWindow();			//�����ھ���
			isLager=true;
		}
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//�����������
CString CListDlg::SaveString()
{
	int List_count=0;
	CString result="";
	CString result1="";
	CString temp="";
	CString temp1="";
	int i;
	List_count=m_Content.GetCount();
	for(i=0;i<List_count;i++)
	{
		m_Content.GetText(i,temp1);
		temp=temp+temp1+"~";
	}
	do
	{
		result=result+temp.Left(temp.Find(" "))+"$";
		temp.Delete(0,temp.Find(" ")+1);
		temp.Delete(0,6);					//7���հ׵�
		result=result+temp.Left(temp.Find("~"))+"~";
		temp.Delete(0,temp.Find("~")+1);
	}while(temp.GetLength()!=0);
	return result;
}


void CListDlg::OnSave() 
{
	// TODO: Add your control notification handler code here
	m_Content.SetCurSel(-1);
	CFileDialog fileSave(FALSE);
	fileSave.m_ofn.lpstrTitle="����ͨѶ¼";
	fileSave.m_ofn.lpstrDefExt="vg";
	fileSave.m_ofn.lpstrFilter="����ͨѶ¼�ļ�(*.vg)\0*.vg\0\0";
	if(IDOK==fileSave.DoModal())
	{
		CString strTemp;
		CFile fileOut(fileSave.GetFileName(),CFile::modeCreate | CFile::modeWrite);
		strTemp=SaveString();
		fileOut.Write(strTemp.GetBuffer(strTemp.GetLength()),strTemp.GetLength());
		strTemp.ReleaseBuffer();
		fileOut.Close();
	}
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//������ϵ�˹������

void CListDlg::OnAdd() 
{
	// TODO: Add your control notification handler code here
	m_Content.SetCurSel(-1);
	CAddBox AddDlg;
	if(1==AddDlg.DoModal())
	{
		int index=LB_ERR;
		index=m_Content.FindStringExact(0,AddDlg.GetShowComb());
		if(index==LB_ERR)
		{
			m_Content.AddString(AddDlg.GetShowComb());
			if(!isLager)						//���û�еĹ�����������������ʾ����
			{
				CRect rect;
				SetWindowPos(NULL,0,0,rectBefore.Width(),rectBefore.Height(),SWP_NOMOVE | SWP_NOZORDER);
				CWnd::CenterWindow();			//�����ھ���
				isLager=true;
			}
		}
		else
		{
			MessageBox("�Ѿ����ڸ���ϵ����","��ʾ");
		}
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//��ť�޸Ĺ�����ʱû�п���

void CListDlg::OnChange() 
{
	// TODO: Add your control notification handler code here
	if(!isLager)
	{
		MessageBox("ͨѶ¼�л�û�����ݣ��޷��޸�����","��ʾ");
	}
	else
	{
		MessageBox("��ʱ�����Ű�ťʽ�޸Ĺ��ܣ����ڹ�����˫��Ҫ�޸ĵ�����","���ߵĻ���");
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//���ҹ������

void CListDlg::OnSearch() 
{
	// TODO: Add your control notification handler code here
	if(!isLager)										//û�м��������ʱ�����˵ͨѶ¼�л�û������
	{
		MessageBox("ͨѶ¼����δ�����ݣ��޷�����","��ʾ");
	}
	else
	{
		CSearchBox SerachDlg;
		int index=-1;
		if(1==SerachDlg.DoModal())
		{
			m_Content.SetCurSel(-1);									//��ֹ�ٴ�Ѱ�ҵ�ʱ����ʾ��һ�ε�ѡ��
			CString name;
			CString temp,temp1;
			CString taname[ITEMCOUNT];
			int List_count,i,count=0;
			List_count=m_Content.GetCount();
			for(i=0;i<List_count;i++)
			{
				m_Content.GetText(i,temp1);
				temp=temp+temp1+"~";
			}
			for(i=0;temp.GetLength()!=0;i++)
			{
				taname[i]=temp.Left(temp.Find(" "))+"$";			//�����ַֿ��浽�����У�������99�����ݣ����һ����ΪѰ�����ֵĽ�����־
				temp.Delete(0,temp.Find(" ")+1);
				temp.Delete(0,6);					//7���հ׵�
				temp.Delete(0,temp.Find("~")+1);
			}
			taname[i]=" ";
			name=SerachDlg.Get_StrName()+"$";
			for(i=0;taname[i]!=" ";i++)
			{
				if(taname[i]==name)
				{
					index=i;
					break;
				}
			}
			if(index==-1)
				MessageBox("�Ҳ�������Ҫ��","��ʾ");
			else
			{
				MessageBox("�ҵ�����Ҫ�ģ��뿴�������ĸ�����","��ʾ");
				m_Content.SetCurSel(index);
			}
		}
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//�˳����������

void CListDlg::OnExit() 
{
	// TODO: Add your control notification handler code here
	PostMessage(WM_QUIT);
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//���ڴ���
void CListDlg::OnAbout() 
{
	// TODO: Add your control notification handler code here
	CAbout	about;
	about.DoModal();
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
