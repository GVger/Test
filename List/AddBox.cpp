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
//��ʼ���������

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
//ͼ��任�������

void CAddBox::OnTimer(UINT nIDEvent) 
{
	// TODO: Add your message handler code here and/or call default
	static int i=1;
	SetIcon(m_icons[i],FALSE);
	i=++i%3;		//��i��0��2ѭ������
	CDialog::OnTimer(nIDEvent);
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//������ϵ�˴��ڵ�ȷ�ϰ�ť�������

void CAddBox::OnOk() 
{
	// TODO: Add your control notification handler code here
	UpdateData();
	if(m_strName.IsEmpty() || m_strPhone.IsEmpty())
	{
		MessageBox("�������������绰����","��ʾ");
	}
	else
	{
		SetSaveComb();
		SetShowComb();
		EndDialog(1);					//����ֵ��������֪��ѡ����ʲô
	}
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////
//���漸���������������ַ���

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
//�Ի���ȡ����ť���

void CAddBox::OnCancel() 
{
	// TODO: Add your control notification handler code here
	EndDialog(0);
}

///////////////////////////////////////////////////////////////////////////////////////////////////////
