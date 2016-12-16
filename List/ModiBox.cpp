// ModiBox.cpp : implementation file
//

#include "stdafx.h"
#include "List.h"
#include "ModiBox.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CModiBox dialog


CModiBox::CModiBox(CWnd* pParent /*=NULL*/)
	: CDialog(CModiBox::IDD, pParent)
{
	//{{AFX_DATA_INIT(CModiBox)
	m_strName = _T("");
	m_strPhone = _T("");
	//}}AFX_DATA_INIT
	m_saveComb=m_showComb=m_strName=m_strPhone="";
}


void CModiBox::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CModiBox)
	DDX_Text(pDX, IDC_NAME, m_strName);
	DDX_Text(pDX, IDC_PHONE, m_strPhone);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CModiBox, CDialog)
	//{{AFX_MSG_MAP(CModiBox)
	ON_WM_TIMER()
	ON_BN_CLICKED(IDC_OK, OnOk)
	ON_BN_CLICKED(IDC_CANCEL, OnCancel)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//��ʼ���������

extern CListApp theApp;
BOOL CModiBox::OnInitDialog() 
{
	CDialog::OnInitDialog();
	
	// TODO: Add extra initialization here


	m_icons[0]=LoadIcon(theApp.m_hInstance,MAKEINTRESOURCE(IDI_ICON1));
	m_icons[1]=LoadIcon(theApp.m_hInstance,MAKEINTRESOURCE(IDI_ICON2));
	m_icons[2]=LoadIcon(theApp.m_hInstance,MAKEINTRESOURCE(IDI_ICON3));

	SetIcon(m_icons[0],FALSE);
	SetTimer(2,1000,NULL);
	return TRUE;  
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//ͼ��任�������

void CModiBox::OnTimer(UINT nIDEvent) 
{
	// TODO: Add your message handler code here and/or call default
	static int i=1;
	SetIcon(m_icons[i],FALSE);
	i=++i%3;		//��i��0��2ѭ������
	CDialog::OnTimer(nIDEvent);
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//�޸Ĵ��ڵ�ȷ�Ϲ������

void CModiBox::OnOk() 
{
	// TODO: Add your control notification handler code here
	UpdateData();						//��ȡ����
	if(m_strName.IsEmpty() || m_strPhone.IsEmpty())				//CStringΪ���򵯳���ʾ
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

CString CModiBox::GetShowComb()
{
	return m_showComb;
}

CString CModiBox::GetSaveComb()
{
	return m_saveComb;
}

void CModiBox::SetSaveComb()
{
	m_saveComb=m_strName+"$"+m_strPhone+"~";
}


void CModiBox::SetShowComb()
{
	m_showComb=m_strName+"       "+m_strPhone;
}


///////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////////////////////////
//�Ի���ȡ����ť���

void CModiBox::OnCancel() 
{
	// TODO: Add your control notification handler code here
	EndDialog(0);	
}

///////////////////////////////////////////////////////////////////////////////////////////////////////
