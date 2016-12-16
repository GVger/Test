#if !defined(AFX_SEARCHBOX_H__E415FD9A_1F03_4F47_AF2C_5A99A365246E__INCLUDED_)
#define AFX_SEARCHBOX_H__E415FD9A_1F03_4F47_AF2C_5A99A365246E__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// SearchBox.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CSearchBox dialog

class CSearchBox : public CDialog
{
// Construction
public:
	CString Get_StrName();
	CSearchBox(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(CSearchBox)
	enum { IDD = IDD_SEARCH };
	CString	m_strName;
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CSearchBox)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(CSearchBox)
	virtual BOOL OnInitDialog();
	afx_msg void OnTimer(UINT nIDEvent);
	afx_msg void OnCancel();
	afx_msg void OnOk();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
private:
	CString m_showComb;
	CString m_saveComb;
	HICON m_icons[3];
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_SEARCHBOX_H__E415FD9A_1F03_4F47_AF2C_5A99A365246E__INCLUDED_)
