#if !defined(AFX_MODIBOX_H__9781CB19_CA8A_4A1A_B08E_B38805ABBFD2__INCLUDED_)
#define AFX_MODIBOX_H__9781CB19_CA8A_4A1A_B08E_B38805ABBFD2__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// ModiBox.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CModiBox dialog

class CModiBox : public CDialog
{
// Construction
public:
	void SetShowComb();
	void SetSaveComb();
	CString GetSaveComb();
	CString GetShowComb();
	CModiBox(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(CModiBox)
	enum { IDD = IDD_MODIBOX };
	CString	m_strName;
	CString	m_strPhone;
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CModiBox)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(CModiBox)
	virtual BOOL OnInitDialog();
	afx_msg void OnTimer(UINT nIDEvent);
	afx_msg void OnOk();
	afx_msg void OnCancel();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
private:
	CString m_showComb;			//显示出来的字符串	
	CString m_saveComb;			//为了存储的字符串
	HICON m_icons[3];
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_MODIBOX_H__9781CB19_CA8A_4A1A_B08E_B38805ABBFD2__INCLUDED_)
