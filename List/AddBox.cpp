// AddBox.cpp : implementation file
//

#include "stdafx.h"
#include "list.h"
#include "AddBox.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CAddBox dialog


CAddBox::CAddBox(CWnd* pParent /*=NULL*/)
	: CDialog(CAddBox::IDD, pParent)
{
	//{{AFX_DATA_INIT(CAddBox)
	m_strName = _T("");
	m_strPhone = _T("");
	//}}AFX_DATA_INIT
}


void CAddBox::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CAddBox)
	DDX_Text(pDX, IDC_NAME, m_strName);
	DDX_Text(pDX, IDC_PHONE, m_strPhone);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CAddBox, CDialog)
	//{{AFX_MSG_MAP(CAddBox)
	ON_WM_TIMER()
	ON_BN_CLICKED(IDC_OK, OnOk)
	ON_BN_CLICKED(IDC_CANCEL, OnCancel)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//初始化窗口完成

extern CListApp theApp;
BOOL CAddBox::OnInitDialog() 
{
	CDialog::OnInitDialog();
	
	// TODO: Add extra initialization here
	m_icons[0]=LoadIcon(theApp.m_hInstance,MAKEINTRESOURCE(IDI_ICON1));
	m_icons[1]=LoadIcon(theApp.m_hInstance,MAKEINTRESOURCE(IDI_ICON2));
	m_icons[2]=LoadIcon(theApp.m_hInstance,MAKEINTRESOURCE(IDI_ICON3));

	SetIcon(m_icons[0],FALSE);
	SetTimer(3,1000,NULL);
	return TRUE;  
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//图标变换功能完成

void CAddBox::OnTimer(UINT nIDEvent) 
{
	// TODO: Add your message handler code here and/or call default
	static int i=1;
	SetIcon(m_icons[i],FALSE);
	i=++i%3;		//让i在0到2循环出现
	CDialog::OnTimer(nIDEvent);
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//增加联系人窗口的确认按钮功能完成

void CAddBox::OnOk() 
{
	// TODO: Add your control notification handler code here
	UpdateData();
	if(m_strName.IsEmpty() || m_strPhone.IsEmpty())
	{
		MessageBox("请输入姓名、电话号码","提示");
	}
	else
	{
		SetSaveComb();
		SetShowComb();
		EndDialog(1);					//返回值让主窗口知道选择了什么
	}
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////
//下面几个函数用来处理字符串

void CAddBox::SetSaveComb()
{
	m_saveComb=m_strName+"$"+m_strPhone+"~";
}

void CAddBox::SetShowComb()
{
	m_showComb=m_strName+"       "+m_strPhone;
}

CString CAddBox::GetSaveComb()
{
	return m_saveComb;
}

CString CAddBox::GetShowComb()
{
	return m_showComb;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////////////////////////
//对话框取消按钮完成

void CAddBox::OnCancel() 
{
	// TODO: Add your control notification handler code here
	EndDialog(0);
}

///////////////////////////////////////////////////////////////////////////////////////////////////////
