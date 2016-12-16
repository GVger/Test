// SearchBox.cpp : implementation file
//

#include "stdafx.h"
#include "list.h"
#include "SearchBox.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CSearchBox dialog
CSearchBox::CSearchBox(CWnd* pParent /*=NULL*/)
	: CDialog(CSearchBox::IDD, pParent)
{
	//{{AFX_DATA_INIT(CSearchBox)
	m_strName = _T("");
	//}}AFX_DATA_INIT
}


void CSearchBox::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CSearchBox)
	DDX_Text(pDX, IDC_NAME, m_strName);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CSearchBox, CDialog)
	//{{AFX_MSG_MAP(CSearchBox)
	ON_WM_TIMER()
	ON_BN_CLICKED(IDC_CANCEL, OnCancel)
	ON_BN_CLICKED(IDC_OK, OnOk)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CSearchBox message handlers



///////////////////////////////////////////////////////////////////////////////////////////////////////
//初始化窗口完成
extern CListApp theApp;
BOOL CSearchBox::OnInitDialog() 
{
	CDialog::OnInitDialog();
	
	// TODO: Add extra initialization here
	m_icons[0]=LoadIcon(theApp.m_hInstance,MAKEINTRESOURCE(IDI_ICON1));
	m_icons[1]=LoadIcon(theApp.m_hInstance,MAKEINTRESOURCE(IDI_ICON2));
	m_icons[2]=LoadIcon(theApp.m_hInstance,MAKEINTRESOURCE(IDI_ICON3));

	SetIcon(m_icons[0],FALSE);
	SetTimer(4,1000,NULL);
	return TRUE;  
}

void CSearchBox::OnTimer(UINT nIDEvent) 
{
	// TODO: Add your message handler code here and/or call default
		static int i=1;
	SetIcon(m_icons[i],FALSE);
	i=++i%3;		//让i在0到2循环出现
	CDialog::OnTimer(nIDEvent);
}

///////////////////////////////////////////////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////////////////////////////////////////
//对话框取消按钮完成

void CSearchBox::OnCancel() 
{
	// TODO: Add your control notification handler code here
	EndDialog(0);
}

///////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////
//下面几个函数用来处理字符串
CString CSearchBox::Get_StrName()
{
	return m_strName;
}

////////////////////////////////////////////////////////////////////////////////////////


void CSearchBox::OnOk() 
{
	// TODO: Add your control notification handler code here
	UpdateData();
	if(m_strName.IsEmpty())
	{
		MessageBox("请输入姓名","提示");
	}
	else
	{
		EndDialog(1);
	}
}


